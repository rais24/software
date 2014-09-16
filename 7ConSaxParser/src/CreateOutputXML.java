import java.io.FileWriter;
import java.io.IOException;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

public class CreateOutputXML {

		//This is the method to create the output xml file
	public void CreateXML(Document Doc)
	{
		XMLOutputFactory factory = XMLOutputFactory.newInstance();
		
		 try {
		     XMLStreamWriter writer = factory.createXMLStreamWriter(new FileWriter("output2.xml"));
		     writer.writeStartDocument();
		     //Element No 1 - Page Start
		     writer.writeCharacters("\n\t");
		     writer.writeStartElement("page");
		     writer.writeAttribute("Type", "");
		     writer.writeAttribute("Percentage", "");
		     writer.writeAttribute("Category", "");
		     
		     writer.writeCharacters("\n\t");
		     //Element No 2 - Adv Start
		     writer.writeStartElement("Adv");
		     
		     writer.writeCharacters("\n\t");
		     //Element No 3 - OuterZone Start
		     
		     writer.writeStartElement("OuterZone");
		     writer.writeAttribute("id", Doc.outerzone.getId());
		     writer.writeAttribute("linkid", Doc.outerzone.getLinkid());
		     writer.writeAttribute("linkpage", Doc.outerzone.getLinkpage());
		     writer.writeAttribute("_linkFrom", Doc.outerzone.getLinkfrom());
		     writer.writeAttribute("Type", Doc.outerzone.getType());
		     writer.writeAttribute("Rectpoint", Doc.outerzone.getRectpoint());
		     writer.writeAttribute("AdvType", Doc.outerzone.getArticletype());
		     writer.writeAttribute("Polypoint", Doc.outerzone.getPolypoint());
		     writer.writeAttribute("userText", Doc.outerzone.getUserText());
		     writer.writeEndElement();
		     //Element No 3 - OuterZone end
		     writer.writeCharacters("\n\t");
		     
		     //Element No 4 - Headline start
		     writer.writeStartElement("Headline");
		     writer.writeAttribute("id", Doc.headline.getId());
		     writer.writeAttribute("Type", Doc.headline.getType());
		     writer.writeAttribute("Rectpoint", Doc.headline.getRectpoint());
		     writer.writeAttribute("Polypoint", Doc.headline.getPolypoint());
		     writer.writeAttribute("rotate", Doc.headline.getRotate());
		     writer.writeAttribute("inverse", Doc.headline.getInverse());
		     writer.writeCharacters(Doc.headline.getExtractedText());
		     writer.writeEndElement();
		     
		     //Element No 4 - Headline End
		     writer.writeCharacters("\n\t");
		     //Element No 5 - Subheadline start
		     
		     writer.writeStartElement("Subheadline");
		     writer.writeAttribute("id", Doc.subheadline.getId());
		     writer.writeAttribute("Type", Doc.subheadline.getType());
		     writer.writeAttribute("Rectpoint", Doc.subheadline.getRectpoint());
		     writer.writeAttribute("Polypoint", Doc.subheadline.getPolypoint());
		     writer.writeAttribute("rotate", Doc.subheadline.getRotate());
		     writer.writeAttribute("inverse", Doc.subheadline.getInverse());
		     writer.writeCharacters(Doc.subheadline.getExtractedText());
		     writer.writeEndElement();
		     
		     //Element No 5 - Subheadline end
		     writer.writeCharacters("\n\t");
		     //Element No 6 - ByLine Start
		     
		     writer.writeStartElement("Byline");
		     writer.writeAttribute("id", Doc.byline.getId());
		     writer.writeAttribute("Type", Doc.byline.getType());
		     writer.writeAttribute("Rectpoint", Doc.byline.getRectpoint());
		     writer.writeAttribute("Polypoint", Doc.byline.getPolypoint());
		     writer.writeAttribute("rotate", Doc.byline.getRotate());
		     writer.writeAttribute("inverse", Doc.byline.getInverse());
		     writer.writeCharacters(Doc.byline.getExtractedText());
		     writer.writeEndElement();
		     
		     //Element No 6 - Byline End
		     writer.writeCharacters("\n\t");
		     //Element No 7 -  Image Start
		     
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
		     // Element No 8 - Photocredit Starts
		     writer.writeStartElement("Photocredit");
		     writer.writeAttribute("id", Doc.photocredit.getId());
		     writer.writeAttribute("Type", Doc.photocredit.getType());
		     writer.writeAttribute("Rectpoint", Doc.photocredit.getRectpoint());
		     writer.writeAttribute("Polypoint", Doc.photocredit.getPolypoint());
		     writer.writeAttribute("rotate", Doc.photocredit.getRotate());
		     writer.writeAttribute("inverse", Doc.photocredit.getInverse());
		     writer.writeCharacters(Doc.photocredit.getExtractedText());
		     writer.writeEndElement();
		     // Element No 8 -  Photocredit End
		     
		     writer.writeCharacters("\n\t");
		     //Element No 9 - Caption Start
		     writer.writeStartElement("Caption");
		     writer.writeAttribute("id", Doc.caption.getId());
		     writer.writeAttribute("Type", Doc.caption.getType());
		     writer.writeAttribute("Rectpoint", Doc.caption.getRectpoint());
		     writer.writeAttribute("Polypoint", Doc.caption.getPolypoint());
		     writer.writeAttribute("rotate", Doc.caption.getRotate());
		     writer.writeAttribute("inverse", Doc.caption.getInverse());
		     writer.writeCharacters(Doc.caption.getExtractedText());
		     writer.writeEndElement();
		     
		     //Element No 9 - Caption End
		     writer.writeCharacters("\n\t");
		     //Element No 10 - Text Start
		     writer.writeStartElement("Text");
		     writer.writeAttribute("id", Doc.text.getId());
		     writer.writeAttribute("Type", Doc.text.getType());
		     writer.writeAttribute("Rectpoint", Doc.text.getRectpoint());
		     writer.writeAttribute("Polypoint", Doc.text.getPolypoint());
		     writer.writeAttribute("rotate", Doc.text.getRotate());
		     writer.writeAttribute("inverse", Doc.text.getInverse());
		     writer.writeCharacters(Doc.text.getExtractedText());
		     writer.writeEndElement();
		     
		     //Element No 10 - Text End
		     writer.writeCharacters("\n\t");
		     
		     writer.writeEndElement();
		     writer.writeCharacters("\n\t");
		     writer.writeEndElement();
		     writer.writeCharacters("\n\t");
		     writer.writeEndDocument();
		     writer.flush();
		     writer.close();

		 } catch (XMLStreamException e) {
		     e.printStackTrace();
		 } catch (IOException e) {
		     e.printStackTrace();
		 }		
	}
}




