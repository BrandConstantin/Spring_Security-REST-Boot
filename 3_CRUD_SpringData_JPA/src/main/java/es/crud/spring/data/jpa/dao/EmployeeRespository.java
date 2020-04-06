package es.crud.spring.data.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import es.crud.spring.data.jpa.entity.Employee;

public interface EmployeeRespository extends JpaRepository<Employee, Integer> {
	// no need to write any code
}
