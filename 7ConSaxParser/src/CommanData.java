
//This class denotes the input that comes along with the xml file. Each item in Document java will be of this type
public class CommanData {

	private String id;
	private String linkid;
	private String linkpage;
	private String _linkfrom;
	private String pageid;
	private String Type;
	private int x1;
	private int y1;
	private int x2;
	private int y2;
	private String AdvType;
	private String Polypoint;
	private String rotate;
	private String inverse;
	private String userText;
	private String Rectpoint;
	private String PageCatagory;
	private String Percentage;
	private String extractedText;
	


	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}


	public String getLinkid() {
		return linkid;
	}
	public void setLinkid(String linkid) {
		this.linkid = linkid;
	}


	public String getLinkpage() {
		return linkpage;
	}
	public void setLinkpage(String linkpage) {
		this.linkpage = linkpage;
	}


	public String getLinkfrom() {
		return _linkfrom;
	}
	public void setLinkfrom(String linkfrom) {
		this._linkfrom = linkfrom;
	}


	public String getPageid() {
		return pageid;
	}
	public void setPageid(String pageid) {
		this.pageid = pageid;
	}


	public String getType() {
		return Type;
	}
	public void setType(String type) {
		this.Type = type;
	}


	public int getX1() {
		return x1;
	}
	public void setX1(int x1) {
		this.x1 = x1;
	}


	public int getY1() {
		return y1;
	}
	public void setY1(int y1) {
		this.y1 = y1;
	}


	public int getX2() {
		return x2;
	}
	public void setX2(int x2) {
		this.x2 = x2;
	}


	public int getY2() {
		return y2;
	}
	public void setY2(int y2) {
		this.y2 = y2;
	}

	public String getArticletype() {
		return AdvType;
	}
	public void setArticleType(String articleType) {
		this.AdvType = articleType;
	}

	public String getPolypoint() {
		return Polypoint;
	}
	public void setPolypoint(String polypoint) {
		this.Polypoint = polypoint;
	}

	public String getRotate() {
		return rotate;
	}
	public void setRotate(String rotate) {
		this.rotate = rotate;
	}

	public String getInverse() {
		return inverse;
	}
	public void setInverse(String inverse) {
		this.inverse = inverse;
	}
	public String getUserText() {
		return userText;
	}
	public void setUserText(String userText) {
		this.userText = userText;
	}
	public String getRectpoint() {
		return Rectpoint;
	}
	public void setRectpoint(String rectpoint) {
		Rectpoint = rectpoint;
	}
	public String getPercentage() {
		return Percentage;
	}
	public void setPercentage(String percentage) {
		Percentage = percentage;
	}
	public String getPageCatagory() {
		return PageCatagory;
	}
	public void setPageCatagory(String pageCatagory) {
		PageCatagory = pageCatagory;
	}
	public String getExtractedText() {
		return extractedText;
	}
	public void setExtractedText(String extractedText) {
		this.extractedText = extractedText;
	}
}
