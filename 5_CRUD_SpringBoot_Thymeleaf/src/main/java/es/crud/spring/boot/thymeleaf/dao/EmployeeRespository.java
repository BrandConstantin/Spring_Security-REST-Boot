package es.crud.spring.boot.thymeleaf.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import es.crud.spring.boot.thymeleaf.entity.Employee;

public interface EmployeeRespository extends JpaRepository<Employee, Integer> {
	// no need to write any code
}
