package com.capgemini.springboot.curddemo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.capgemini.springboot.curddemo.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	private EntityManager entityManager;
	@Autowired
	public EmployeeDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	
	@Override
	public List<Employee> findAll() {
		//create a query and get result as list
		TypedQuery<Employee> query = entityManager.createQuery("from Employee",Employee.class);
		return query.getResultList();
	}


	@Override
	public Employee findById(int id) {
		Employee employee = entityManager.find(Employee.class, id);
		return employee;
	}


	@Override
	public Employee save(Employee emp) {
		
		Employee employee = entityManager.merge(emp);
		return employee;
	}

	@Override
	public void deleteById(int id) {
		Employee employee = entityManager.find(Employee.class, id);
		entityManager.remove(employee);
		
	}

}
