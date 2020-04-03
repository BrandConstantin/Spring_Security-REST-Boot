package es.spring.rest.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.spring.rest.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	private List<Student> theStudents;

	// define @PostConstruct to load the student data only once
	@PostConstruct
	public void loadData() {
		theStudents = new ArrayList<>();

		theStudents.add(new Student("Paul", "Larhard"));
		theStudents.add(new Student("Mary", "Godwin"));
		theStudents.add(new Student("Smith", "Voucher"));
	}

	// define endpoint for "/students" - return a list
	@GetMapping("/students")
	public List<Student> getStudents() {
		return theStudents;
	}
	
	// define endpoint for "/students/{studentId}" -return index
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {
		// index into the list		
		
		// check the studentId against list size
		if((studentId >= theStudents.size()) || (studentId < 0)) {
			throw new StudentNotFoundException("Student id not found " + studentId);
		}
		return theStudents.get(studentId);
	}
}