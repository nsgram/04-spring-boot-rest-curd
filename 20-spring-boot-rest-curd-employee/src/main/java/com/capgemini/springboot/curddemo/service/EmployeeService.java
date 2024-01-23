package com.capgemini.springboot.curddemo.service;

import java.util.List;

import com.capgemini.springboot.curddemo.entity.Employee;

public interface EmployeeService {
	
	List<Employee> findAll();
	Employee findById(int id);
	Employee save(Employee employee);
	void deleteById(int id);

}
