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

	public void runEngine(String xmlfilepath, String imagefilepath, String outputfolderpath) {
		//This is the path of the xml file, going forward to be added as input argument
		
		//String inputXML="/Users/rishirais/Downloads/Test/XML/RNK_20140915_00_A_003_V00.xml";
		//String inputImageFile="/Users/rishirais/Downloads/Test/JPG/RNK_20140915_00_A_003_V00.jpg";
		
		String inputXML=xmlfilepath;
		String inputImageFile=imagefilepath;
		
		
		String getFilepathParseArray[]= inputXML.split("/");
		String getFileName=getFilepathParseArray[getFilepathParseArray.length-1];
		
		String outputfilePath=outputfolderpath+"/"+ getFileName;
		//Document type declared
		List<Document> docList=parseDocumentXML(inputXML);
		
		for(Document doc : docList){
			
			
			//This is used to fill the object with the text extracted from Tesseract
			if(doc.headline!=null)
			{
			doc.headline=TesseractExtractor.getImageText(doc.headline.getRectpoint(), inputImageFile, doc.headline);
			}
			if(doc.subheadline!=null)
			{
			doc.subheadline=TesseractExtractor.getImageText(doc.subheadline.getRectpoint(), inputImageFile, doc.subheadline);
			}
			
			if(doc.byline!=null)
			{
			doc.byline=TesseractExtractor.getImageText(doc.byline.getRectpoint(), inputImageFile, doc.byline);
			}
			//Some advertisements do not have photographs
			if(doc.photocredit!=null)
			{
			doc.photocredit=TesseractExtractor.getImageText(doc.photocredit.getRectpoint(), inputImageFile, doc.photocredit);
			}
			
			if(doc.caption!=null)
			{
			doc.caption=TesseractExtractor.getImageText(doc.caption.getRectpoint(), inputImageFile, doc.caption);
			}
			if(doc.text!=null)
			{
			doc.text=TesseractExtractor.getImageText(doc.text.getRectpoint(), inputImageFile, doc.text);
			}
			
			CreateOutputXML output= new CreateOutputXML();
			output.CreateXML(doc,outputfilePath,docList.size());
		   
		}
	}

	private static List<Document> parseDocumentXML(String fileName) {

		List<Document> docList = new ArrayList<Document>();
		Document doc = null;
		DataAllocator allocator=null;
		XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
		try {
			XMLStreamReader xmlStreamReader = xmlInputFactory.createXMLStreamReader(new FileInputStream(fileName));
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
			e.printStackTrace();
		}
		return docList;
	}
}