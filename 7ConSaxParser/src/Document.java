import java.util.List;



//These are the elements of each pdf page or article.
public class Document {
	public  CommanData outerzone;
	public  CommanData headline;
	public  CommanData subheadline;
	public  CommanData byline;
	public  CommanData image;
	public  CommanData photocredit;
	public  CommanData caption;
	public  CommanData text;
    public List<CommanData> multipletext;
    public List<CommanData> multipleimage;
    public List<CommanData> multiplephotocredit;
    public List<CommanData> multiplecaption;
    
    
    
	public CommanData getOuterzone() {
		return outerzone;
	}
	public void setOuterzone(CommanData outerzone) {
		this.outerzone = outerzone;
	}


	public CommanData getHeadline() {
		return headline;
	}
	public void setHeadline(CommanData headline) {
		this.headline = headline;
	}


	public CommanData getByline() {
		return byline;
	}

	public void setByline(CommanData byline) {
		this.byline = byline;
	}


	public CommanData getSubheadline() {
		return subheadline;
	}
	public void setSubheadline(CommanData subheadline) {
		this.subheadline = subheadline;
	}


	public CommanData getImage() {
		return image;
	}
	public void setImage(CommanData image) {
		this.image = image;
	}


	public CommanData getPhotocredit() {
		return photocredit;
	}
	public void setPhotocredit(CommanData photocredit) {
		this.photocredit = photocredit;
	}


	public CommanData getCaption() {
		return caption;
	}
	public void setCaption(CommanData caption) {
		this.caption = caption;
	}

	public CommanData getText() {
		return text;
	}
	public void setText(CommanData text) {
		this.text = text;
	}
	
	public List<CommanData> getMultipleText() {
		return (List<CommanData>) multipletext;
	}
	public void setMultipleText(CommanData multipletext) {
		this.multipletext = (List<CommanData>) multipletext;
	}
	
	public List<CommanData> getMultipleImage(){
		return (List<CommanData>) multipleimage;
	}
	public void setMultipleImage(CommanData multipleimage) {
		this.multipleimage = (List<CommanData>) multipleimage;
	}
	
	
	public List<CommanData> getMultiplePhotocredit(){
		return (List<CommanData>) multiplephotocredit;
	}
	public void setMultiplePhotocredit(CommanData multiplephotocredit) {
		this.multiplephotocredit = (List<CommanData>) multiplephotocredit;
	}
	
	public List<CommanData> getMultipleCaption(){
		return (List<CommanData>) multiplecaption;
	}
	public void setMultipleCaption(CommanData multiplecaption) {
		this.multiplecaption = (List<CommanData>) multiplecaption;
	}
	
	public void setId(int parseInt) {
		// TODO Auto-generated method stub
		
	}

}
