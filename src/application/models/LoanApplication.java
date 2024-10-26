package application.models;

import application.abstractClasses.Person;

public class LoanApplication extends Person {
	String type;
	String age;
	double price;
	double downPay;
	double interest;
	int numOfMonths;
	String frequency;
	double monthlyPay;
	
	public LoanApplication(String type, String age, double price, double downPay, double interest,
			int numOfMonths, String freqency, double monthlyPay, String name, int num, String city, String province) {
		this.setName(name);
		this.setPhone(num);
		this.setCity(city);
		this.setProvince(province);
		this.type = type;
		this.age = age;
		this.price = price;
		this.downPay = downPay;
		this.interest = interest;
		this.numOfMonths = numOfMonths;
		this.frequency = freqency;
		this.monthlyPay = monthlyPay;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getDownPay() {
		return downPay;
	}
	public void setDownPay(double downPay) {
		this.downPay = downPay;
	}
	public double getInterest() {
		return interest;
	}
	public void setInterest(double interest) {
		this.interest = interest;
	}
	public int getNumOfMonths() {
		return numOfMonths;
	}
	public void setNumOfMonths(int numOfMonths) {
		this.numOfMonths = numOfMonths;
	}
	public String getFrequency() {
		return frequency;
	}
	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}
	public double getMonthlyPay() {
		return monthlyPay;
	}
	public void setMonthlyPay(double monthlyPay) {
		this.monthlyPay = monthlyPay;
	}
}
