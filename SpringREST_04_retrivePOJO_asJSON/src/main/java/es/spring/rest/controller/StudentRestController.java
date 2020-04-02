package es.spring.rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.spring.rest.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	// define endpoint for "/students" - return a list
	@GetMapping("/students")
	public List<Student> getStudents(){
		List<Student> theStudents = new ArrayList<>();
		
		theStudents.add(new Student("Paul", "Larhard"));
		theStudents.add(new Student("Mary", "Godwin"));
		theStudents.add(new Student("Smith", "Voucher"));
		
		return theStudents;
	}
}
