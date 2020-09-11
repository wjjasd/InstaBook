package db;

public class UserVO {
	
	private String id_user;
	private String pw_user;
	private String nickname_user;
	private String gender_user;
	private String birth_user;
	
	
	public String getId_user() {
		return id_user;
	}
	public void setId_user(String id_user) {
		this.id_user = id_user;
	}
	public String getPw_user() {
		return pw_user;
	}
	public void setPw_user(String pw_user) {
		this.pw_user = pw_user;
	}
	public String getNickname_user() {
		return nickname_user;
	}
	public void setNickname_user(String nickname_user) {
		this.nickname_user = nickname_user;
	}
	public String getGender_user() {
		return gender_user;
	}
	public void setGender_user(String gender_user) {
		this.gender_user = gender_user;
	}
	public String getBirth_user() {
		return birth_user;
	}
	public void setBirth_user(String birth_user) {
		this.birth_user = birth_user;
	}

}
