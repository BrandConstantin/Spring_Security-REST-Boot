package es.crud.spring.boot.thymeleaf.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import es.crud.spring.boot.thymeleaf.entity.Employee;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	// load employee data
	private List<Employee> theEmployees;
	
	@PostConstruct
	private void loadData() {
		// create employees
		Employee emp1 = new Employee(0, "Leslie", "Andrews", "and@les.uk");
		Employee emp2 = new Employee(1, "Vasily", "Doftowansky", "doftowansyvasyly@rusia.ru");
		Employee emp3 = new Employee(2, "Svansten", "Hortlop", "sh@company.sw");
		
		// create the list
		theEmployees = new ArrayList<>();
		
		// add to the list
		theEmployees.add(emp3);
		theEmployees.add(emp2);
		theEmployees.add(emp1);
	}
	
	// add mapping for /list
	@GetMapping("/list")
	public String listEmployees(Model theModel) {
		// add to the spring model
		theModel.addAttribute("employees", theEmployees);
		
		return "list-employees";
	}
}
