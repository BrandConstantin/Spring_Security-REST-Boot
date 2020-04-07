package es.crud.spring.boot.thymeleaf.service;

import java.util.List;

import es.crud.spring.boot.thymeleaf.entity.Employee;

public interface EmployeeService {
	public List<Employee> findAll();
	public Employee findById(int theId);
	public void save(Employee theEmployee);
	public void deleteById(int theId);
}
