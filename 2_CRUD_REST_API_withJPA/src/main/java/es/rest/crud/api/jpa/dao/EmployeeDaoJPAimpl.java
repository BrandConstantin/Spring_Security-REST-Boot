package es.rest.crud.api.jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import es.rest.crud.api.jpa.entity.Employee;

@Repository
public class EmployeeDaoJPAimpl implements EmployeeDAO {
	private EntityManager entityManager;
	
	@Autowired
	public EmployeeDaoJPAimpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Override
	public List<Employee> findAll() {
		// create a query
		Query theQuery = entityManager.createQuery("from Employee");
		
		// execute the query and ger result list
		List<Employee> employees = theQuery.getResultList();
		
		return employees;
	}

	@Override
	public Employee findById(int theId) {
		Employee theEmployee = entityManager.find(Employee.class, theId);
		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {
		// save or update
		Employee dbEmployee = entityManager.merge(theEmployee);
		
		// update with id from db
		theEmployee.setId(dbEmployee.getId());
	}

	@Override
	public void deleteById(int theId) {
		// delte object
		Query theQuery = entityManager.createQuery("delete from Employee where id=:employeeId");
		theQuery.setParameter("employeeId", theId);
		theQuery.executeUpdate();

	}

}
