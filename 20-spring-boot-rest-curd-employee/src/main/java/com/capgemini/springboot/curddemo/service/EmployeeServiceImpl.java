package com.capgemini.springboot.curddemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.springboot.curddemo.dao.EmployeeDAO;
import com.capgemini.springboot.curddemo.entity.Employee;
@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDAO dao;
	@Autowired
	public EmployeeServiceImpl(EmployeeDAO dao) {
		this.dao =dao;
	}
	
	@Override
	public List<Employee> findAll() {
		return dao.findAll();
	}

	@Override
	public Employee findById(int id) {
		return dao.findById(id);
	}

	@Override
	@Transactional
	public Employee save(Employee employee) {
		
		return dao.save(employee);
	}

	@Override
	@Transactional
	public void deleteById(int id) {
		dao.deleteById(id);
		
	}

}
