

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
	public void setId(int parseInt) {
		// TODO Auto-generated method stub
		
	}

}
