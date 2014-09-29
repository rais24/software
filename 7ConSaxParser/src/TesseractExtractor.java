import java.io.File;
import java.util.ArrayList;
import java.util.List;


import net.sourceforge.tess4j.*;

import java.awt.*;

import javax.imageio.spi.IIORegistry;
import javax.imageio.spi.ImageInputStreamSpi;
import javax.imageio.spi.ImageOutputStreamSpi;
import javax.imageio.spi.ImageReaderSpi;
import javax.imageio.spi.ImageWriterSpi;
import javax.swing.JTextArea;

import com.sun.media.imageioimpl.stream.ChannelImageInputStreamSpi;
import com.sun.media.imageioimpl.stream.ChannelImageOutputStreamSpi;

public class TesseractExtractor 
{
	public static CommanData getImageText(String coordinates, String filePath,CommanData dataObj,JTextArea textArea)
	{
		// get coordindates from the string
		String result=null;
		try {
			String[] coordinateArray = coordinates.split(",");
			// Create tesseract instane
			File imageFile = new File(filePath);
			Tesseract instance = Tesseract.getInstance();  // JNA Interface Mapping
			//	Tesseract1 instance= new Tesseract1();
			instance.setHocr(false);
			instance.setLanguage("eng");
			instance.setOcrEngineMode(2);	
			
			//instance.setTessVariable("tessedit_ocr_engine_mode", "2");
			//instance.setLanguage("eng");

			int x1= Integer.parseInt(coordinateArray[0]);
			int y1= Integer.parseInt(coordinateArray[1]);
			int x2= Integer.parseInt(coordinateArray[2]);
			int y2= Integer.parseInt(coordinateArray[3]);

			int width=x2-x1;
			int height=y2-y1;
			//Pass coordinates to instance
			Rectangle rect= new Rectangle(x1,y1,width,height);
	//		textArea.append("\n");
	//		textArea.append("Width is :" +width);
	//		textArea.append("\n");
	//		textArea.append("Instance is :" +instance.toString());
	//		textArea.append("\n");
	//		textArea.append("Begin OCR with file :"+imageFile);

			IIORegistry registry =IIORegistry.getDefaultInstance();
			
		//	IIORegistry registry2= new IIORegistry();
			registry.registerServiceProvider(new
			com.sun.media.imageioimpl.plugins.tiff.TIFFImageWriterSpi());
			registry.registerServiceProvider(new 
			com.sun.media.imageioimpl.plugins.tiff.TIFFImageReaderSpi());

			result = instance.doOCR(imageFile,rect);
	//		textArea.append("\n");

	//		textArea.append("End OCR");
			dataObj.setExtractedText(result);
		} catch (TesseractException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			textArea.append("Exception is being thrown");
			textArea.append(e.getMessage());
		}
		catch(Exception e){
			textArea.append("Exception is being thrown");
			textArea.append(e.getMessage());
		}
		return dataObj;
	}



	//New Method created to handle multiple cases of the same attribute
	public static List<CommanData> getImageText(String filePath,List<CommanData> multipletext,JTextArea textArea)
	{
		// get coordindates from the string
		String result=null;
		try {

			for(CommanData data:multipletext)
			{	
				String coordinates=data.getRectpoint();
				String[] coordinateArray = coordinates.split(",");
				// Create tesseract instance
				File imageFile = new File(filePath);
				Tesseract instance = Tesseract.getInstance();  // JNA Interface Mapping
				//Tesseract1 instance= new Tesseract1();
				instance.setHocr(false);
				//	instance.setTessVariable("tessedit_ocr_engine_mode", "");


				instance.setLanguage("eng");
				instance.setOcrEngineMode(2);	

				//instance.setLanguage("eng");

				int x1= Integer.parseInt(coordinateArray[0]);
				int y1= Integer.parseInt(coordinateArray[1]);
				int x2= Integer.parseInt(coordinateArray[2]);
				int y2= Integer.parseInt(coordinateArray[3]);

				int width=x2-x1;
				int height=y2-y1;
				//Pass coordinates to instance
				Rectangle rect= new Rectangle(x1,y1,width,height);
				
				IIORegistry registry =IIORegistry.getDefaultInstance();
				registry.registerServiceProvider(new
				com.sun.media.imageioimpl.plugins.tiff.TIFFImageWriterSpi());
				registry.registerServiceProvider(new 
				com.sun.media.imageioimpl.plugins.tiff.TIFFImageReaderSpi());
				
				result = instance.doOCR(imageFile,rect);
			//	textArea.append("\n");

			//textArea.append("End OCR");

				data.setExtractedText(result);
			}
		} catch (TesseractException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return multipletext;
	}
}
