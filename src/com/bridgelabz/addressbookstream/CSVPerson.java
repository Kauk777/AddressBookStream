package com.bridgelabz.addressbookstream;

import com.opencsv.bean.CsvBindByName;

public class CSVPerson {
	
	@CsvBindByName(column="fName")
	private String firstName;
	
	@CsvBindByName(column="lName")
	private String lastName;
	
	@CsvBindByName(column="address")
	private String PersonAddress;
	
	@CsvBindByName(column="city")
	private String city;
	
	@CsvBindByName(column="state")
	private String state;
	
	@CsvBindByName(column="zip")
	private String zip;
	
	@CsvBindByName(column="phoneNo")
	private String phone;
	
	@CsvBindByName(column="email")
	private String email;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPersonAddress() {
		return PersonAddress;
	}

	public void setPersonAddress(String personAddress) {
		PersonAddress = personAddress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
