package db;

public class PostVO {

	//String id_user, String date_post, String hash_post, String img_post, int like_post2
	
	private String id_user;
	private String date_post;
	private String hash_post;
	private String img_post;
	private int like_post;
	
	
	public String getId_user() {
		return id_user;
	}
	public void setId_user(String id_user) {
		this.id_user = id_user;
	}
	public String getDate_post() {
		return date_post;
	}
	public void setDate_post(String date_post) {
		this.date_post = date_post;
	}
	public String getHash_post() {
		return hash_post;
	}
	public void setHash_post(String hash_post) {
		this.hash_post = hash_post;
	}
	public String getImg_post() {
		return img_post;
	}
	public void setImg_post(String img_post) {
		this.img_post = img_post;
	}
	public int getLike_post() {
		return like_post;
	}
	public void setLike_post(int like_post) {
		this.like_post = like_post;
	}
	
	
	
}
