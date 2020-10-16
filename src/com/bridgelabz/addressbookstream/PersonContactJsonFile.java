package com.bridgelabz.addressbookstream;

import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class PersonContactJsonFile {
	private static final String PERSON_JSON_SAMPLE = "personjsonfile.json";
	
	public void writeJsonFile() throws Exception {
		try {
			List<Person> persons=Arrays.asList(new Person("Joshua", "Patrick", "Mave Hill 025", "Las Vegas", "California", "C25042", "25478963", "joshua@green.com"), 
					new Person("Mave", "Carla", "Durga Street24", "Durgapur", "West Bengal", "254186", "96848933","carla@gmail.com"), 
					new Person("Sidharth", "Kahali", "Neptune street", "Panji", "Goa", "831005", "88514355", "kahali@hotmail.com"));
			
			// Creating Gson instance
			 Gson gson = new GsonBuilder().setPrettyPrinting().create();
			 
			 Writer writer = Files.newBufferedWriter(Paths.get(PERSON_JSON_SAMPLE));
			 
			 // converting person objects to JSON file
			 gson.toJson(persons, writer);
			 
			 writer.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void readJsonFile() throws Exception {
		try {
			Gson gson = new Gson();
			Reader reader = Files.newBufferedReader(Paths.get(PERSON_JSON_SAMPLE));
			List<Person> persons=Arrays.asList(gson.fromJson(reader, Person[].class));
			persons.forEach(System.out::println);
			reader.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
