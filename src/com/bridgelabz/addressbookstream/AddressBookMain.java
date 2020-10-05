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
	
	public void viewSortedDetails() {
		Map<String,Person> sortedMap=contactMap.entrySet().stream()
				.sorted(Map.Entry.comparingByKey())
				.collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,(oldValue,newValue)->oldValue,LinkedHashMap::new));
	    for(Map.Entry<String,Person> sm:sortedMap.entrySet()) {
	    	System.out.println(sm.getKey());
	    	System.out.println(sm.getValue());
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
	
	public void viewPersonByState(String statename) {
		Collection<Person> values=contactMap.values();
		List<Person> stateList=values.stream().filter(p->statename.equals(p.state)).collect(Collectors.toList());	
		Map<String,List<Person>> personByState=stateList.stream().collect(Collectors.groupingBy(Person::getState));
		for(Map.Entry<String,List<Person>> m:personByState.entrySet()) {
			System.out.println(m.getKey());
			System.out.println(m.getValue());
		}
		System.out.println("Number of person conatcts in "+statename+" is: "+stateList.stream().count());
	}
	
	public void viewPersonByCity(String cityname) {
		Collection<Person> values=contactMap.values();
		List<Person> cityList=values.stream().filter(p->cityname.equals(p.city)).collect(Collectors.toList());	
		Map<String,List<Person>> personByCity=cityList.stream().collect(Collectors.groupingBy(Person::getCity));
		for(Map.Entry<String,List<Person>> m:personByCity.entrySet()) {
			System.out.println(m.getKey());
			System.out.println(m.getValue());
		}
		System.out.println("Number of person conatcts in "+cityname+" is: "+cityList.stream().count());
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
		addBook.addDetails("Mave", "Carla", "Durga Street24", "Durgapur", "West Bengal", "254186", 96848933, "carla@gmail.com");
		addBook.addDetails("Shyansh", "Kumar", "Kali Marg 257", "Kolkata", "West Bengal", "254156", 84848933, "shyansh1998@gmail.com");
		addBook.viewDetails();
		boolean flag=true;
		System.out.println("1. Edit address detail based on person name");
		System.out.println("2. Delete address detail based on person name");
		System.out.println("3. View person names by state");
		System.out.println("4. View person names by city");
		System.out.println("5. View sorted address details by person name");
		System.out.println("6. Exit");
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
				String spname=sc.nextLine();
				addBook.viewPersonByState(spname);
				break;
			case 4:
				System.out.println("Enter the city name");
				sc.nextLine();
				String cpname=sc.nextLine();
				addBook.viewPersonByCity(cpname);
				break;
			case 5:
				System.out.println("Alphabetically sorted details");
				addBook.viewSortedDetails();
				break;
			case 6:
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
