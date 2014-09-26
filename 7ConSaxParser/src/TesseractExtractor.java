import java.io.File;
import java.util.ArrayList;
import java.util.List;


import net.sourceforge.tess4j.*;

import java.awt.*;

public class TesseractExtractor 
{
	public static CommanData getImageText(String coordinates, String filePath,CommanData dataObj)
	{
		// get coordindates from the string
		String result=null;
		try {
			String[] coordinateArray = coordinates.split(",");
			// Create tesseract instane
			File imageFile = new File(filePath);
			Tesseract instance = Tesseract.getInstance();  // JNA Interface Mapping
			
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
			result = instance.doOCR(imageFile,rect);
	
			dataObj.setExtractedText(result);
		} catch (TesseractException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dataObj;
	}



    //New Method created to handle multiple cases of the same attribute
	public static List<CommanData> getImageText(String filePath,List<CommanData> multipletext)
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
			
				result = instance.doOCR(imageFile,rect);
			
				data.setExtractedText(result);
			}
		} catch (TesseractException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return multipletext;
	}
}
