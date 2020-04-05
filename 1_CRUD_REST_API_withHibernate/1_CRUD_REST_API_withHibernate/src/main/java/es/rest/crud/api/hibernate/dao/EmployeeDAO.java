package es.rest.crud.api.hibernate.dao;

import java.util.List;

import es.rest.crud.api.hibernate.entity.Employee;

public interface EmployeeDAO {
	public List<Employee> findAll();
}
