package com.capgemini.springboot.curddemo.dao;

import java.util.List;

import com.capgemini.springboot.curddemo.entity.Employee;

public interface EmployeeDAO {
	
	List<Employee> findAll();
	Employee findById(int id);
	Employee save(Employee employee);
	void deleteById(int id);
	
}
