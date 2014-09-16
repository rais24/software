import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;



public class StaxXMLStreamReader {

	//Add variables for Documents

	
	//Above code is added for Documents

	public static void main(String[] args) {
		//This is the path of the xml file, going forward to be added as input argument
		
		String inputXML="/Users/rishirais/Downloads/For OCR SERVICES/For OCR SERVICES/XML/RNK_20140815_00_A_002_V00.xml";
		String inputImageFile="/Users/rishirais/Downloads/For OCR SERVICES/For OCR SERVICES/JPG/RNK_20140815_00_A_002_V00.jpg";
		
		//Document type declared
		List<Document> docList=parseDocumentXML(inputXML);
		for(Document doc : docList){
			
			//This is used to fill the object with the text extracted from Tesseract
			doc.headline=TesseractExtractor.getImageText(doc.headline.getRectpoint(), inputImageFile, doc.headline);
			doc.subheadline=TesseractExtractor.getImageText(doc.subheadline.getRectpoint(), inputImageFile, doc.subheadline);
			doc.byline=TesseractExtractor.getImageText(doc.byline.getRectpoint(), inputImageFile, doc.byline);
			doc.photocredit=TesseractExtractor.getImageText(doc.photocredit.getRectpoint(), inputImageFile, doc.photocredit);
			doc.caption=TesseractExtractor.getImageText(doc.caption.getRectpoint(), inputImageFile, doc.caption);
			doc.text=TesseractExtractor.getImageText(doc.text.getRectpoint(), inputImageFile, doc.text);
			
			
		//	System.out.println("Headline is : " +doc.headline.getExtractedText());
			
		//	System.out.println("Sub Headline is :" +doc.subheadline.getExtractedText());
			
		//	System.out.println("ByLine is :" +doc.byline.getExtractedText());
			
		//	System.out.println("PhotoCredit is :" +doc.photocredit.getExtractedText());
			
		//	System.out.println("Caption is :" +doc.caption.getExtractedText());
			
		//	System.out.println("Text is : " +doc.text.getExtractedText());
			CreateOutputXML output= new CreateOutputXML();
			output.CreateXML(doc);
	
		   
			   
		}
	}

	private static List<Document> parseDocumentXML(String fileName) {

		List<Document> docList = new ArrayList<Document>();
		Document doc = null;
		DataAllocator allocator=null;
		XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
		try {
			XMLStreamReader xmlStreamReader = xmlInputFactory.createXMLStreamReader(new FileInputStream(fileName));
			//System.out.println("Going here -2 "); 
			allocator= new DataAllocator();
			int event = xmlStreamReader.getEventType();
			while(true){
				switch(event) {

				case XMLStreamConstants.START_ELEMENT:
					if(xmlStreamReader.getLocalName().equals("Adv")){
						
						//This populates the Document object
					}else if(xmlStreamReader.getLocalName().equals("OuterZone")){
						doc = new Document();
						doc.outerzone= new CommanData();
						doc.setId(Integer.parseInt(xmlStreamReader.getAttributeValue(0)));
						doc.outerzone=allocator.FillObject(xmlStreamReader, doc.outerzone);
						
					}else if(xmlStreamReader.getLocalName().equals("Headline")){
						doc.headline= new CommanData();
						doc.headline=allocator.FillObject(xmlStreamReader, doc.headline);
						
					}else if(xmlStreamReader.getLocalName().equals("Subheadline")){
						doc.subheadline=new CommanData();
						doc.subheadline=allocator.FillObject(xmlStreamReader, doc.subheadline);
						
					}else if(xmlStreamReader.getLocalName().equals("Byline")){
						doc.byline=new CommanData();;
						doc.byline=allocator.FillObject(xmlStreamReader, doc.byline);

					}else if(xmlStreamReader.getLocalName().equals("Image")){
						doc.image=new CommanData();
						doc.image=allocator.FillObject(xmlStreamReader, doc.image);
						
					}else if(xmlStreamReader.getLocalName().equals("Photocredit")){
						doc.photocredit=new CommanData();
						doc.photocredit=allocator.FillObject(xmlStreamReader, doc.photocredit);
						
					}else if(xmlStreamReader.getLocalName().equals("Caption")){
						doc.caption=new CommanData();
						doc.caption=allocator.FillObject(xmlStreamReader, doc.caption);
					
					}else if(xmlStreamReader.getLocalName().equals("Text")){
						doc.text=new CommanData();
						doc.text=allocator.FillObject(xmlStreamReader, doc.text);
						
					}
					break;

 				case XMLStreamConstants.END_ELEMENT:
					if(xmlStreamReader.getLocalName().equals("Adv")){
						docList.add(doc);
					}
					break;
				}
				if (!xmlStreamReader.hasNext())
					break;

				event = xmlStreamReader.next();
			}

		} catch (FileNotFoundException  e) {
			e.printStackTrace();
		} catch (XMLStreamException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return docList;
	}


}