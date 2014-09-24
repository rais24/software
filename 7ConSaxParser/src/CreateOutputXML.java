import java.io.FileWriter;
import java.io.IOException;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;


public class CreateOutputXML {
	static int count= 0;

	//This is the method to create the output xml file
	public void CreateXML(Document Doc,String fileName,int noDocs)
	{

		System.out.println("System Message :  The output xml is being created at : " + fileName);

		XMLOutputFactory factory = XMLOutputFactory.newInstance();

		try {

			factory.setProperty("escapeCharacters", false);

			XMLStreamWriter	writer = factory.createXMLStreamWriter(new FileWriter(fileName,true));

			//This part should only be written once hence only for first document

			if(count==0)

			{
				writer.writeCharacters("<?xml version= \"1.0\" encoding=\"UTF-8\"?>");
				//Element No 1 - Page Start
				writer.writeCharacters("\n\t");
				writer.writeStartElement("page");
				writer.writeAttribute("Type", "");
				writer.writeAttribute("Percentage", "");
				writer.writeAttribute("Category", "");

			}
			writer.writeCharacters("\n\t");
			//Element No 2 - Adv Start
			writer.writeStartElement("Adv");

			writer.writeCharacters("\n\t");
			//Element No 3 - OuterZone Start

			writer.writeStartElement("OuterZone");
			writer.writeAttribute("id", Doc.outerzone.getId());
			if( Doc.outerzone.getLinkid()!=null)
			{
				writer.writeAttribute("linkid", Doc.outerzone.getLinkid());
			}
			if(Doc.outerzone.getLinkpage()!=null)
			{
				writer.writeAttribute("linkpage", Doc.outerzone.getLinkpage());
			}
			if(Doc.outerzone.getLinkfrom()!=null)
			{
				writer.writeAttribute("_linkFrom", Doc.outerzone.getLinkfrom());
			}
			writer.writeAttribute("Type", Doc.outerzone.getType());
			writer.writeAttribute("Rectpoint", Doc.outerzone.getRectpoint());
			writer.writeAttribute("AdvType", Doc.outerzone.getArticletype());
			writer.writeAttribute("Polypoint", Doc.outerzone.getPolypoint());
			writer.writeAttribute("userText", Doc.outerzone.getUserText());
			writer.writeEndElement();
			//Element No 3 - OuterZone end
			writer.writeCharacters("\n\t");

			//Element No 4 - Headline start
			if(Doc.headline!=null)
			{
				writer.writeStartElement("Headline");
				writer.writeAttribute("id", Doc.headline.getId());
				writer.writeAttribute("Type", Doc.headline.getType());
				writer.writeAttribute("Rectpoint", Doc.headline.getRectpoint());
				writer.writeAttribute("Polypoint", Doc.headline.getPolypoint());
				writer.writeAttribute("rotate", Doc.headline.getRotate());
				writer.writeAttribute("inverse", Doc.headline.getInverse());
				writer.writeCharacters("<p>");
				writer.writeCharacters(Doc.headline.getExtractedText().trim());
				writer.writeCharacters("</p>");
				writer.writeEndElement();

				//Element No 4 - Headline End
				writer.writeCharacters("\n\t");
			}
			//Element No 5 - Subheadline start

			if(Doc.subheadline!=null)
			{
				writer.writeStartElement("Subheadline");
				writer.writeAttribute("id", Doc.subheadline.getId());
				writer.writeAttribute("Type", Doc.subheadline.getType());
				writer.writeAttribute("Rectpoint", Doc.subheadline.getRectpoint());
				writer.writeAttribute("Polypoint", Doc.subheadline.getPolypoint());
				writer.writeAttribute("rotate", Doc.subheadline.getRotate());
				writer.writeAttribute("inverse", Doc.subheadline.getInverse());
				writer.writeCharacters("<p>");

				writer.writeCharacters(Doc.subheadline.getExtractedText().trim());
				writer.writeCharacters("</p>");
				writer.writeEndElement();
				//Element No 5 - Subheadline end
				writer.writeCharacters("\n\t");
			}
			//Element No 6 - ByLine Start

			if(Doc.byline!=null)
			{
				writer.writeStartElement("Byline");
				writer.writeAttribute("id", Doc.byline.getId());
				writer.writeAttribute("Type", Doc.byline.getType());
				writer.writeAttribute("Rectpoint", Doc.byline.getRectpoint());
				writer.writeAttribute("Polypoint", Doc.byline.getPolypoint());
				writer.writeAttribute("rotate", Doc.byline.getRotate());
				writer.writeAttribute("inverse", Doc.byline.getInverse());
				writer.writeCharacters("<p>");
				writer.writeCharacters(Doc.byline.getExtractedText().trim());
				writer.writeCharacters("</p>");
				writer.writeEndElement();

				//Element No 6 - Byline End
				writer.writeCharacters("\n\t");
			}
			//Element No 7 -  Image Start

		/*	if(Doc.image!=null)
			{
				writer.writeStartElement("Image");
				writer.writeAttribute("id", Doc.image.getId());
				writer.writeAttribute("Type", Doc.image.getType());
				writer.writeAttribute("Rectpoint", Doc.image.getRectpoint());
				writer.writeAttribute("Polypoint", Doc.image.getPolypoint());
				writer.writeAttribute("rotate", Doc.image.getRotate());
				writer.writeAttribute("inverse", Doc.image.getInverse());
				writer.writeAttribute("pageid", Doc.image.getPageid());
				writer.writeEndElement();
				//Element No 7 - Image End
				writer.writeCharacters("\n\t");
			}
			*/
			if(Doc.multipleimage!=null)
			{
				for(CommanData imageData:Doc.multipleimage)
				{
				writer.writeStartElement("Image");
				writer.writeAttribute("id", imageData.getId());
				writer.writeAttribute("Type", imageData.getType());
				writer.writeAttribute("Rectpoint", imageData.getRectpoint());
				writer.writeAttribute("Polypoint", imageData.getPolypoint());
				writer.writeAttribute("rotate", imageData.getRotate());
				writer.writeAttribute("inverse", imageData.getInverse());
				writer.writeAttribute("pageid", imageData.getPageid());
				writer.writeEndElement();
				//Element No 7 - Image End
				writer.writeCharacters("\n\t");
				}
			}
			
			
			
			// Element No 8 - Photocredit Starts

			/*if(Doc.photocredit!=null)
			{
				writer.writeStartElement("Photocredit");
				writer.writeAttribute("id", Doc.photocredit.getId());
				writer.writeAttribute("Type", Doc.photocredit.getType());
				writer.writeAttribute("Rectpoint", Doc.photocredit.getRectpoint());
				writer.writeAttribute("Polypoint", Doc.photocredit.getPolypoint());
				writer.writeAttribute("rotate", Doc.photocredit.getRotate());
				writer.writeAttribute("inverse", Doc.photocredit.getInverse());
				writer.writeCharacters("<p>");
				writer.writeCharacters(Doc.photocredit.getExtractedText().trim());
				writer.writeCharacters("</p>");
				writer.writeEndElement();
				writer.writeCharacters("\n\t");
			}*/
			// Element No 8 -  Photocredit End

			if(Doc.multiplephotocredit!=null)
			{
				for(CommanData photocreditData:Doc.multiplephotocredit)
				{
				writer.writeStartElement("Photocredit");
				writer.writeAttribute("id", photocreditData.getId());
				writer.writeAttribute("Type", photocreditData.getType());
				writer.writeAttribute("Rectpoint", photocreditData.getRectpoint());
				writer.writeAttribute("Polypoint", photocreditData.getPolypoint());
				writer.writeAttribute("rotate", photocreditData.getRotate());
				writer.writeAttribute("inverse", photocreditData.getInverse());
				writer.writeCharacters("<p>");
				writer.writeCharacters(photocreditData.getExtractedText().trim());
				writer.writeCharacters("</p>");
				writer.writeEndElement();
				writer.writeCharacters("\n\t");
				}
			}

			//Element No 9 - Caption Start

		/*	if(Doc.caption!=null)
			{
				writer.writeStartElement("Caption");
				writer.writeAttribute("id", Doc.caption.getId());
				writer.writeAttribute("Type", Doc.caption.getType());
				writer.writeAttribute("Rectpoint", Doc.caption.getRectpoint());
				writer.writeAttribute("Polypoint", Doc.caption.getPolypoint());
				writer.writeAttribute("rotate", Doc.caption.getRotate());
				writer.writeAttribute("inverse", Doc.caption.getInverse());
				writer.writeCharacters("<p>");
				writer.writeCharacters(Doc.caption.getExtractedText().trim());
				writer.writeCharacters("</p>");
				writer.writeEndElement();
				writer.writeCharacters("\n\t");
			}*/
			
			
			if(Doc.multiplecaption!=null)
			{
				for(CommanData multiplecaptionData:Doc.multiplecaption)
				{
				writer.writeStartElement("Caption");
				writer.writeAttribute("id", multiplecaptionData.getId());
				writer.writeAttribute("Type", multiplecaptionData.getType());
				writer.writeAttribute("Rectpoint", multiplecaptionData.getRectpoint());
				writer.writeAttribute("Polypoint", multiplecaptionData.getPolypoint());
				writer.writeAttribute("rotate", multiplecaptionData.getRotate());
				writer.writeAttribute("inverse", multiplecaptionData.getInverse());
				writer.writeCharacters("<p>");
				writer.writeCharacters(multiplecaptionData.getExtractedText().trim());
				writer.writeCharacters("</p>");
				writer.writeEndElement();
				writer.writeCharacters("\n\t");
				}
			}
			
			
			//Element No 9 - Caption End


		/*	if(Doc.text!=null)
			{
				//Element No 10 - Text Start
				writer.writeStartElement("Text");
				writer.writeAttribute("id", Doc.text.getId());
				writer.writeAttribute("Type", Doc.text.getType());
				writer.writeAttribute("Rectpoint", Doc.text.getRectpoint());
				writer.writeAttribute("Polypoint", Doc.text.getPolypoint());
				writer.writeAttribute("rotate", Doc.text.getRotate());
				writer.writeAttribute("inverse", Doc.text.getInverse());

				String[] splitParagraphs=Doc.text.getExtractedText().split("\n\n");

				for(int i=0; i<splitParagraphs.length;i++)
				{
					System.out.println("Going inside the split");
					writer.writeCharacters("\n\t");
					writer.writeCharacters("<p>");
					//writer.writeCharacters(Doc.text.getExtractedText().trim());
					writer.writeCharacters(splitParagraphs[i].trim());
					writer.writeCharacters("</p>");
				}
				//writer.writeCharacters(replacedText);

				writer.writeEndElement();
			}*/


			if(Doc.multipletext!=null)
			{

				for(CommanData textData:Doc.multipletext)
				{
					//Element No 10 - Text Start
					writer.writeStartElement("Text");
					writer.writeAttribute("id", textData.getId());
					writer.writeAttribute("Type", textData.getType());
					writer.writeAttribute("Rectpoint", textData.getRectpoint());
					writer.writeAttribute("Polypoint", textData.getPolypoint());
					writer.writeAttribute("rotate", textData.getRotate());
					writer.writeAttribute("inverse", textData.getInverse());

					String[] splitParagraphs=textData.getExtractedText().split("\n\n");

					for(int i=0; i<splitParagraphs.length;i++)
					{
						System.out.println("Going inside the split");
						writer.writeCharacters("\n\t");
						writer.writeCharacters("<p>");
						//writer.writeCharacters(Doc.text.getExtractedText().trim());
						writer.writeCharacters(splitParagraphs[i].trim());
						writer.writeCharacters("</p>");
					}
					//writer.writeCharacters(replacedText);

					writer.writeEndElement();
					writer.writeCharacters("\n\t");
				}
			}

			//Element No 10 - Text End

			writer.writeEndElement();

			//This is for the page end
			if(count==(noDocs-1))
			{
				writer.writeCharacters("\n\t");
				writer.writeCharacters("</page>");
				writer.writeEndDocument();
			}

			writer.flush();
			writer.close();
			count++;

			System.out.println("System Message : Output Generated for Document : " + count+1);

		} catch (XMLStreamException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
		System.out.println("System Message :  All Outputs are generated");
	}
}




