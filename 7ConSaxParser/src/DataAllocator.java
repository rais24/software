import javax.xml.stream.XMLStreamReader;


public class DataAllocator {

	public CommanData FillObject(XMLStreamReader xmlStreamReader, CommanData dataObj)
	{
		//This is the get the total no of attributes associated with that property
		int noofattributes=xmlStreamReader.getAttributeCount();
		
		//Iterating over the no. of attributes
		for(int i=0;i<noofattributes;i++)
		{
			String docattribute=xmlStreamReader.getAttributeLocalName(i);
			//System.out.println("The attribute name is :" +docattribute);
			//System.out.println("The attribute value is"+xmlStreamReader.getAttributeValue(i));
			
			if(docattribute.equalsIgnoreCase("id")) 
			{
				dataObj.setId(xmlStreamReader.getAttributeValue(i).toString());	  
			}

			if(docattribute.equalsIgnoreCase("linkid")) 
			{
				dataObj.setLinkid(xmlStreamReader.getAttributeValue(i));
			}
			if(docattribute.equalsIgnoreCase("linkpage")) 
			{
				dataObj.setLinkpage(xmlStreamReader.getAttributeValue(i));
			}
			if(docattribute.equalsIgnoreCase("_linkFrom")) 
			{
				dataObj.setLinkfrom(xmlStreamReader.getAttributeValue(i));
			}
			if(docattribute.equalsIgnoreCase("Type")) 
			{
				dataObj.setType(xmlStreamReader.getAttributeValue(i));
			}
			if(docattribute.equalsIgnoreCase("Rectpoint")) 
			{
				dataObj.setRectpoint(xmlStreamReader.getAttributeValue(i));
			}
			if(docattribute.equalsIgnoreCase("AdvType")) 
			{
				dataObj.setArticleType(xmlStreamReader.getAttributeValue(i));
			}
			if(docattribute.equalsIgnoreCase("Polypoint")) 
			{
				dataObj.setPolypoint(xmlStreamReader.getAttributeValue(i));
			}
			if(docattribute.equalsIgnoreCase("userText")) 
			{
				dataObj.setUserText(xmlStreamReader.getAttributeValue(i));
			}
			if(docattribute.equalsIgnoreCase("inverse")) 
			{
				dataObj.setInverse(xmlStreamReader.getAttributeValue(i));
			}
			if(docattribute.equalsIgnoreCase("rotate")) 
			{
				dataObj.setRotate(xmlStreamReader.getAttributeValue(i));
			}
			if(docattribute.equalsIgnoreCase("pageid")) 
			{
				dataObj.setPageid(xmlStreamReader.getAttributeValue(i));
			}
			if(docattribute.equalsIgnoreCase("PageCatagory")) 
			{
				dataObj.setPageCatagory(xmlStreamReader.getAttributeValue(i));
			}
			if(docattribute.equalsIgnoreCase("Percentage")) 
			{
				dataObj.setPercentage(xmlStreamReader.getAttributeValue(i));
			}
		}
		return dataObj;
	}
}



