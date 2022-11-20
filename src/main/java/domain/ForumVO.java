package domain;

public class ForumVO {
	private String creator;
	private String category;
	private String user_id;
	private String content;
	private String upload_date;
	
	public String getCreator() {
		return creator;
	}
	public String getCategory() {
		return category;
	}
	public String getUser_id() {
		return user_id;
	}
	public String getContent() {
		return content;
	}
	public String getUpload_date() {
		return upload_date;
	}
	
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setUpload_date(String upload_date) {
		this.upload_date = upload_date;
	}
}
