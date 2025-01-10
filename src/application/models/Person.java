package application.models;

import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;

public class Person {
	SimpleStringProperty name;
	SimpleLongProperty phone;
	SimpleStringProperty city;
	SimpleStringProperty province;
	Person(){
		name = new SimpleStringProperty();
		phone = new SimpleLongProperty();
		city = new SimpleStringProperty();
		province = new SimpleStringProperty();
	}
	public SimpleStringProperty nameProperty() {
		return this.name;
	}
	
	public String getName() {
		return this.nameProperty().get();
	}
	
	public void setName(final String name) {
		this.nameProperty().set(name);
	}
	
	public SimpleLongProperty phoneProperty() {
		return this.phone;
	}
	
	public long getPhone() {
		return this.phoneProperty().get();
	}
	
	public void setPhone(final long phone) {
		this.phoneProperty().set(phone);
	}
	
	public SimpleStringProperty cityProperty() {
		return this.city;
	}
	
	public String getCity() {
		return this.cityProperty().get();
	}
	
	public void setCity(final String city) {
		this.cityProperty().set(city);
	}
	
	public SimpleStringProperty provinceProperty() {
		return this.province;
	}
	
	public String getProvince() {
		return this.provinceProperty().get();
	}
	
	public void setProvince(final String province) {
		this.provinceProperty().set(province);
	}
}
