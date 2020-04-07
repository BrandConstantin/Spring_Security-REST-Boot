package es.crud.spring.boot.thymeleaf.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import es.crud.spring.boot.thymeleaf.entity.Employee;

public interface EmployeeRespository extends JpaRepository<Employee, Integer> {
	public List<Employee> findAllByOrderByLastNameAsc(); //it's all part of Spring Data JPA
}
