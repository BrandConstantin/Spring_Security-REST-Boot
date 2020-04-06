package es.rest.crud.api.jpa.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.rest.crud.api.jpa.dao.EmployeeDAO;
import es.rest.crud.api.jpa.entity.Employee;
import es.rest.crud.api.jpa.service.EmployeeService;

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
	
	// add mapping for GET /employees/{employeeId}
	@GetMapping("/employees/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId) {
		Employee theEmployee = employeeService.findById(employeeId);
		
		if(theEmployee == null) {
			throw new RuntimeException("Employee with id " + employeeId + " not found");
		}
		
		return theEmployee;
	}
	
	// add mapping for POST /employees - add new
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee theEmployee) {
		// also just in case they pass an id in json
		// to force a save of new item
		theEmployee.setId(0);
		employeeService.save(theEmployee);
		return theEmployee;
	}
	
	// add mapping for PUT /employees - update existing id
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee theEmployee) {
		employeeService.save(theEmployee);
		return theEmployee;
	}
	
	// add mapping for DELETE /employees/{employeeId}
	@DeleteMapping("/employees/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId) {
	Employee tempEmployee = employeeService.findById(employeeId);
		// throw exception if not find the id
	if(tempEmployee == null) {
		throw new RuntimeException("Employee with id " + employeeId + " not found");
	}
	employeeService.deleteById(employeeId);
	
	return "Deleted employed with id " + employeeId;
	}
}
