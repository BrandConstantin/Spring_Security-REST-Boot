package es.crud.spring.data.rest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import es.crud.spring.data.rest.entity.Employee;

public interface EmployeeRespository extends JpaRepository<Employee, Integer> {
	// no need to write any code
}
