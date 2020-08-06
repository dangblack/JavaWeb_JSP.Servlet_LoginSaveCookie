package entity;

public class Account {
	private String userName;
	private String passWord;
	private String gender;
	private String role;
	public Account(String userName, String passWord, String gender, String role) {
		this.userName = userName;
		this.passWord = passWord;
		this.gender = gender;
		this.role = role;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "Account [userName=" + userName + ", passWord=" + passWord + ", gender=" + gender + ", role=" + role
				+ "]";
	}


}
