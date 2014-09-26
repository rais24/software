import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;



public class StaxXMLStreamReader {

	//Add variables for Documents
	
	//Above code is added for Documents

	public static boolean runEngine(String xmlfilepath, String imagefilepath, String outputfolderpath)
//	public static void main(String[] args)
	{
		//This is the path of the xml file, going forward to be added as input argument
		
		//Add 3 inputs
		//inout xml file path
		//input jpg file path
		//output file folder
		
		
		//String inputXML="/Users/rishirais/Downloads/Test/XML/RNK_20140915_00_B_008_V00.xml";
	//	String inputImageFile="/Users/rishirais/Downloads/Test/JPG/RNK_20140915_00_B_008_V00.jpg";
		
		String inputXML=xmlfilepath;
		String inputImageFile=imagefilepath;
		
		//String inputXML=args[0];
		//String inputImageFile=args[1];
		
		
		Path path= Paths.get(inputXML);
		
	//	System.out.println("Input file Path is :" +inputXML);
	//	String getFilepathParseArray[]= inputXML.split("/\/");
		
	//	String getFileName=getFilepathParseArray[getFilepathParseArray.length-1];
		
	//	System.out.println("Input file Name is :" +path.getFileName().toString());
		
		//String outputfilePath=outputfolderpath+"/"+ getFileName;
		//String outputfilePath="/Users/rishirais/Downloads/Test/Output/"+getFileName;
		//String outputfilePath=args[2]+getFileName;
		String outputfilePath=outputfolderpath+"\\"+path.getFileName().toString();
		

		//Document type declared
		List<Document> docList=parseDocumentXML(inputXML);
		
		System.out.println("Status Message : Engine Running, total number of Documents is :" + docList.size());
		for(Document doc : docList){
			
			System.out.println("System Message : Processing coordinates using Tesseract and Cube");
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
			doc.multiplephotocredit=TesseractExtractor.getImageText(inputImageFile,doc.multiplephotocredit);
			}
			
			if(doc.caption!=null)
			{
			doc.multiplecaption=TesseractExtractor.getImageText(inputImageFile,doc.multiplecaption);
			}
			if(doc.text!=null)
			{
			doc.multipletext=TesseractExtractor.getImageText(inputImageFile,doc.multipletext);
			}

			CreateOutputXML output= new CreateOutputXML();
			output.CreateXML(doc,outputfilePath,docList.size());
		}
	
	return true;
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
			//List<CommanData> textList=new List<CommanData>();
			
			System.out.println("Status Message : Loading Document");
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
						if(doc.multipleimage==null)
						{
							doc.multipleimage= new ArrayList<CommanData>();
						}
						doc.multipleimage.add(doc.image);
						
						
					}else if(xmlStreamReader.getLocalName().equals("Photocredit")){
						doc.photocredit=new CommanData();
						doc.photocredit=allocator.FillObject(xmlStreamReader, doc.photocredit);
						if(doc.multiplephotocredit==null)
						{
							doc.multiplephotocredit= new ArrayList<CommanData>();
						}
						doc.multiplephotocredit.add(doc.photocredit);
						
						
					}else if(xmlStreamReader.getLocalName().equals("Caption")){
						doc.caption=new CommanData();
						doc.caption=allocator.FillObject(xmlStreamReader, doc.caption);
						if(doc.multiplecaption==null)
						{
							doc.multiplecaption= new ArrayList<CommanData>();
						}
						doc.multiplecaption.add(doc.caption);
						
					}else if(xmlStreamReader.getLocalName().equals("Text")){
						doc.text=new CommanData();
						doc.text=allocator.FillObject(xmlStreamReader, doc.text);
						if(doc.multipletext==null)
						{
							doc.multipletext= new ArrayList<CommanData>();
						}
						doc.multipletext.add(doc.text);
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