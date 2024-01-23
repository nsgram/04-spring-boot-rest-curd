package com.capgemini.springboot.curddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.springboot.curddemo.entity.Employee;
import com.capgemini.springboot.curddemo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
	private  EmployeeService service;
	//quick and dirty : inject employee by constructor 
	@Autowired
	public EmployeeRestController(EmployeeService service) {
		this.service = service;
	}
	//expose "/employees" endpoint return list of employee
	@GetMapping("/employees")
	public List<Employee> findAll(){
		return service.findAll();
	}
	
	
	//add mapping for GET /employees/{employeesId}
	@GetMapping("/employees/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId) {
		Employee employee = service.findById(employeeId);
		if (employee == null) {
			throw new RuntimeException("Employee id not found -"+employeeId);
			
		}
		return employee;
	}
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee employee) {
		employee.setId(0);
		Employee empDb = service.save(employee);
		return empDb;
	}
	//update existing employee
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee employee) {
		Employee empDb = service.save(employee);
		return empDb;
	}
	
	@DeleteMapping("/employees/{employeeId}")
	public String deleteEmployeeById(@PathVariable int employeeId) {
		Employee employee = service.findById(employeeId);
		if (employee == null) {
			throw new RuntimeException("Employee id not found -"+employeeId);
			
		}
		service.deleteById(employeeId);
		return "deleted emp id :"+employeeId;
	}
	
}
