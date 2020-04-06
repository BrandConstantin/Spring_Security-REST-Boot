package es.crud.spring.data.jpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.crud.spring.data.jpa.dao.EmployeeRespository;
import es.crud.spring.data.jpa.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	private EmployeeRespository employeeRepository;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRespository theEmployeeRepository) {
		employeeRepository = theEmployeeRepository;
	}

	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee findById(int theId) {		
		Optional<Employee> result = employeeRepository.findById(theId);
		
		Employee theEnEmployee = null;
		if(result.isPresent()) {
			theEnEmployee = result.get();
		}else {
			// we dind't find the employee
			throw new RuntimeException("Did not find employee with id " + theId);
		}
		return theEnEmployee;
	}

	@Override
	public void save(Employee theEmployee) {
		employeeRepository.save(theEmployee);
	}

	@Override
	public void deleteById(int theId) {
		employeeRepository.deleteById(theId);
	}
}
