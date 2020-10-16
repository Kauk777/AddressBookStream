package com.bridgelabz.addressbookstream;

import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.opencsv.CSVWriter;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;

public class PersonContactCsvFile {
	
	private static final String PERSON_LIST_SAMPLE = "personcsvfile.csv";
	
	public void csvReader() throws Exception {
		try {
			Reader reader = Files.newBufferedReader(Paths.get(PERSON_LIST_SAMPLE));
			CsvToBean<CSVPerson> csvToBean = new CsvToBeanBuilder<CSVPerson>(reader)
                    .withType(CSVPerson.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
			
			List<CSVPerson> csvPersons=csvToBean.parse();
			
			for(CSVPerson csvPerson:csvPersons) {
				System.out.println("First Name: "+csvPerson.getFirstName());
				System.out.println("Last Name: "+csvPerson.getLastName());
				System.out.println("Address: "+csvPerson.getPersonAddress());
				System.out.println("City: "+csvPerson.getCity());
				System.out.println("State: "+csvPerson.getState());
				System.out.println("Zip: "+csvPerson.getZip());
				System.out.println("Phone Number: "+csvPerson.getPhone());
				System.out.println("Email: "+csvPerson.getEmail());
				System.out.println("------------------------------------------");
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void csvWriter() throws Exception {
		Writer writer = Files.newBufferedWriter(Paths.get(PERSON_LIST_SAMPLE));
		StatefulBeanToCsv<Person> csvWriter = new StatefulBeanToCsvBuilder<Person>(writer)
				.withSeparator(CSVWriter.DEFAULT_SEPARATOR)
                .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                .withEscapechar(CSVWriter.DEFAULT_ESCAPE_CHARACTER)
                .withLineEnd(CSVWriter.DEFAULT_LINE_END)
                .withOrderedResults(true)
                .build();
			List<Person> personList=new ArrayList<>();
			personList.add(new Person("Joshua", "Patrick", "Mave Hill 025", "Las Vegas", "California", "C25042", "25478963", "joshua@green.com"));
			personList.add(new Person("Staya", "Veda", "Kali Marg 254", "Kolkata", "West Bengal", "254156", "75848933", "veda@gmail.com"));
			personList.add(new Person("Shyansh", "Kumar", "Kali Marg 257", "Kolkata", "West Bengal", "254156", "84848933","shyansh1998@gmail.com"));
			personList.add(new Person("Felix", "George", "Hollywood street101", "Las Vegas", "California", "C54106", "9948933","felix42@gmail.com"));
			
			csvWriter.write(personList);
			writer.close();
	}
}
