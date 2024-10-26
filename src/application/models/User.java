package application.models;

public class User {
	String userName;
	String password;
	
	public User(String name, String pwd){
		//No user validation is done as these are hard coded
		this.userName = name;
		this.password = pwd;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public String getPassword() {
		return password;
	}
}
