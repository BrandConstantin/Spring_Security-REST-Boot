package es.rest.crud.api.hibernate.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.rest.crud.api.hibernate.dao.EmployeeDAO;
import es.rest.crud.api.hibernate.entity.Employee;
import es.rest.crud.api.hibernate.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	private EmployeeService employeeService;
	
	@Autowired
	public EmployeeRestController(EmployeeService theEmployeeService) {
		employeeService = theEmployeeService;
	}
	
	// expose "/employees" and return a list
	@GetMapping("/employees")
	public List<Employee> findAll(){
		return employeeService.findAll();
	}
}
