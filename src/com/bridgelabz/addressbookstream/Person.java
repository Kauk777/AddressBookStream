package com.bridgelabz.addressbookstream;

public class Person {
	public String fName;
	public String lName;
	private String address;
	private String city;
	private String state;
	private String zip;
	private long phoneNo;
	private String email;
	
	public Person(String fName, String lName, String address, String city, String state, String zip, long phoneNo,
			String email) {
		this.fName = fName;
		this.lName = lName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phoneNo = phoneNo;
		this.email = email;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o==this)
			return true;
		if(!(o instanceof Person))
			return false;
		Person op=(Person)o;
		return fName.equals(op.fName) && lName.equals(op.lName);
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

	@Override
	public String toString() {
		return "Person Address [FirstName=" + fName + ", LastName=" + lName + ", address=" + address + ", city=" + city + ", state="
				+ state + ", zip=" + zip + ", phoneNo=" + phoneNo + ", email=" + email + "]";
	}
}
