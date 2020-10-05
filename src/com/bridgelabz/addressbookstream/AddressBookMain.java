package com.bridgelabz.addressbookstream;

import java.util.*;
import java.util.stream.Collectors;


public class AddressBookMain {
	
private Map<String,Person> contactMap;
	
	public AddressBookMain() {
		contactMap = new HashMap<>();
	}
	
	public void addDetails(String fname,String lname, String address, String city, String state, String zip, long phno, String email) {
		Person p=new Person(fname,lname,address,city,state,zip,phno,email);
		String name=fname+" "+lname;
		contactMap.put(name, p);
	}
	
	public void viewDetails() {
		System.out.println(contactMap.size()+" entries");
		for(Map.Entry<String,Person> m:contactMap.entrySet()) {
			System.out.println(m.getKey());
			System.out.println(m.getValue());
		}
	}
	
	public void editDetails(String fname, String lname) {
		for(Map.Entry<String,Person> m:contactMap.entrySet()) {
			if(m.getValue().fName.equals(fname) && m.getValue().lName.equals(lname)) {
				Person editedDetails=new Person(fname,lname,"Dew Point","Melbourne","Queens","P2548",785412,"joshua@hotmail.com");
				contactMap.replace(m.getKey(),editedDetails);
				System.out.println("Edited Details of "+fname+" "+lname+": "+editedDetails);
			}		
		}
	}
	
	public void deleteDetails(String fname, String lname) {
		for(Map.Entry<String,Person> m:contactMap.entrySet()) {
			if(m.getValue().fName.equals(fname) && m.getValue().lName.equals(lname)) {
				System.out.println("Deleted "+fname+" "+lname+" address");
				contactMap.remove(m.getKey());
				return;
			}	
		}
	}
	
	public void viewByState(String stateName) {
		Collection<Person> values=contactMap.values();
		List<Person> stateList=values.stream().filter(p->stateName.equals(p.state)).collect(Collectors.toList());
		stateList.stream().forEach(p->{ 
			System.out.println(p.fName+" "+p.lName);
			System.out.println(p);});	
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		AddressBookMain addBook=new AddressBookMain();
		addBook.addDetails("Joshua", "Patrick", "Mave Hill 025", "Las Vegas", "California", "C25042", 25478963, "joshua@green.com");
		addBook.addDetails("Staya", "Veda", "Kali Marg 254", "Kolkata", "West Bengal", "254156", 75848933, "veda@gmail.com");
		addBook.addDetails("Zao", "Vikigh", "Yellow River R10", "Xinju", "Bejing", "745156", 98848933, "zao@gmail.com");
		addBook.addDetails("Zao", "Vikigh", "Yellow Plain R10", "Xinju", "Bejing", "745156", 98848933, "zao@gmail.com");
		addBook.addDetails("Momba", "High", "Venus street", "Panji", "Goa", "831005", 84512355, "high@hotmail.com");
		addBook.addDetails("Sidharth", "Kahali", "Neptune street", "Panji", "Goa", "831005", 88514355, "kahali@hotmail.com");
		addBook.addDetails("Veda", "Veenet", "Mars street", "Panji", "Goa", "831045", 68514355, "veenet@hotmail.com");
		addBook.viewDetails();
		boolean flag=true;
		System.out.println("1. Edit address detail based on person name");
		System.out.println("2. Delete address detail based on person name");
		System.out.println("3. Address details of persons based on state");
		System.out.println("4. Exit");
		while(flag) {
			System.out.println("Enter your choice");
			int ch=sc.nextInt();
			switch(ch) {
			case 1: 
				System.out.println("Enter name to edit its address");
				String fname=sc.next();
				String lname=sc.next();
				addBook.editDetails(fname,lname);
				break;
			case 2:
				System.out.println("Enter name to delete its address");
				String fdname=sc.next();
				String ldname=sc.next();
				addBook.deleteDetails(fdname,ldname);
				break;
			case 3:
				System.out.println("Enter the state name");
				sc.nextLine();
				String sname=sc.nextLine();
				addBook.viewByState(sname);
				break;
			case 4:
				flag=false;
				break;
			default:
				System.out.println("Enter valid option");
			}
		}
		System.out.println("New address details");
		addBook.viewDetails();
	}

}
