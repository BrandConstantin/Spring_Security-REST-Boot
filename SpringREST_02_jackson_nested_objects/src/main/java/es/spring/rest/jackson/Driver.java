package es.spring.rest.jackson;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {
	public static void main(String[] args) {
		try {
			// create object mapper
			ObjectMapper mapper = new ObjectMapper();

			// read JSON file and map/convert to Java POJO
			Student theStudent = mapper.readValue(new File("data/sample-full.json"), Student.class);

			// print first name and last name
			System.out.println("First name = " + theStudent.getFirstName());
			System.out.println("Last name = " + theStudent.getLastName());
			
			// print address
			Address tempAddress = theStudent.getAddress();
			System.out.println("Address = " + tempAddress.getStreet() + " " + tempAddress.getCity());
			
			// print languages
			for (String tempLang : theStudent.getLanguages()) {
				System.out.print(tempLang + " ");
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
