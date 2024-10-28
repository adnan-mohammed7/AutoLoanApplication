package application.models;

import application.models.Person;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class LoanApplication extends Person {
	SimpleStringProperty type;
	SimpleStringProperty age;
	SimpleDoubleProperty price;
	SimpleDoubleProperty downPay;
	SimpleDoubleProperty interest;
	SimpleIntegerProperty numOfMonths;
	SimpleStringProperty frequency;
	SimpleDoubleProperty pay;
	
	public LoanApplication(String type, String age, double price, double downPay, double interest,
			int numOfMonths, String freqency, double pay, String name, long num, String city, String province) {
		super();
		this.setName(name);
		this.setPhone(num);
		this.setCity(city);
		this.setProvince(province);
		this.type = new SimpleStringProperty(type);
		this.age = new SimpleStringProperty(age);
		this.price = new SimpleDoubleProperty(price);
		this.downPay = new SimpleDoubleProperty(downPay);
		this.interest = new SimpleDoubleProperty(interest);
		this.numOfMonths = new SimpleIntegerProperty(numOfMonths);
		this.frequency = new SimpleStringProperty(freqency);
		this.pay = new SimpleDoubleProperty(pay);
	}

	public SimpleStringProperty typeProperty() {
		return this.type;
	}
	

	public String getType() {
		return this.typeProperty().get();
	}
	

	public void setType(String type) {
		this.typeProperty().set(type);
	}
	

	public SimpleStringProperty ageProperty() {
		return this.age;
	}
	

	public String getAge() {
		return this.ageProperty().get();
	}
	

	public void setAge(String age) {
		this.ageProperty().set(age);
	}
	

	public SimpleDoubleProperty priceProperty() {
		return this.price;
	}
	

	public double getPrice() {
		return this.priceProperty().get();
	}
	

	public void setPrice(double price) {
		this.priceProperty().set(price);
	}
	

	public SimpleDoubleProperty downPayProperty() {
		return this.downPay;
	}
	

	public double getDownPay() {
		return this.downPayProperty().get();
	}
	

	public void setDownPay(double downPay) {
		this.downPayProperty().set(downPay);
	}
	

	public SimpleDoubleProperty interestProperty() {
		return this.interest;
	}
	

	public double getInterest() {
		return this.interestProperty().get();
	}
	

	public void setInterest(double interest) {
		this.interestProperty().set(interest);
	}
	

	public SimpleIntegerProperty numOfMonthsProperty() {
		return this.numOfMonths;
	}
	

	public int getNumOfMonths() {
		return this.numOfMonthsProperty().get();
	}
	

	public void setNumOfMonths(int numOfMonths) {
		this.numOfMonthsProperty().set(numOfMonths);
	}
	

	public SimpleStringProperty frequencyProperty() {
		return this.frequency;
	}
	

	public String getFrequency() {
		return this.frequencyProperty().get();
	}
	

	public void setFrequency(String frequency) {
		this.frequencyProperty().set(frequency);
	}
	

	public SimpleDoubleProperty payProperty() {
		return this.pay;
	}
	

	public double getPay() {
		return this.payProperty().get();
	}
	

	public void setPay(double pay) {
		this.payProperty().set(pay);
	}
	
	@Override
	public String toString() {
		return this.getName() + ", " + this.getType() + ", " +this.getInterest(); 
	}
}
