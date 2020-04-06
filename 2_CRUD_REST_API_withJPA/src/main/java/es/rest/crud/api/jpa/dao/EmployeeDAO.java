package es.rest.crud.api.jpa.dao;

import java.util.List;

import es.rest.crud.api.jpa.entity.Employee;

public interface EmployeeDAO {
	public List<Employee> findAll();
	
	public Employee findById(int theId);
	public void save(Employee theEmployee);
	public void deleteById(int theId);
}
