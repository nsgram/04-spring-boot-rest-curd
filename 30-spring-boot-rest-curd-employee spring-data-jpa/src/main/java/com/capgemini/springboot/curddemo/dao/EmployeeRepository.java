package com.capgemini.springboot.curddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.springboot.curddemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
