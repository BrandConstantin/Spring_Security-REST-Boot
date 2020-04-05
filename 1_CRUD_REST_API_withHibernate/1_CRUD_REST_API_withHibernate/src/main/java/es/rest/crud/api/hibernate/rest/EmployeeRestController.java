package es.rest.crud.api.hibernate.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.rest.crud.api.hibernate.dao.EmployeeDAO;
import es.rest.crud.api.hibernate.entity.Employee;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	private EmployeeDAO employeeDAO;
	
	// inject employee dao
	@Autowired
	public EmployeeRestController(EmployeeDAO theEmployeeDAO) {
		employeeDAO = theEmployeeDAO;
	}
	
	// expose "/employees" and return a list
	@GetMapping("/employees")
	public List<Employee> findAll(){
		return employeeDAO.findAll();
	}
}
