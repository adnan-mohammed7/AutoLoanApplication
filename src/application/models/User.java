/**********************************************
Workshop #3
Course:APD 545 - Semester 5
Last Name: Mohammed
First Name: Adnan
ID: 174731216
Section: ZAA
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature
Date: 28th October 2024
**********************************************/

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
