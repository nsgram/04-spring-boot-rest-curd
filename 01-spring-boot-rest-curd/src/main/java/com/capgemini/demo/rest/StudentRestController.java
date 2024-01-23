package com.capgemini.demo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.demo.entity.Student;
import com.capgemini.demo.entity.StudentErrorResponse;
import com.capgemini.demo.exceptions.StudentNotFound;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	private List<Student> theStudent;
	//load data
	@PostConstruct
	public void loadData() {
		
		theStudent = new ArrayList<Student>();
		theStudent.add(new Student("Poornima", "Patel"));
		theStudent.add(new Student("Mario", "Rossi"));
		theStudent.add(new Student("Marry", "Smith"));
		
	}
	
	
	
	
	// define end point
	
	@GetMapping("/students")
	
	public List<Student> getStudents() {
		theStudent = new ArrayList<Student>();
		theStudent.add(new Student("Poornima", "Patel"));
		theStudent.add(new Student("Mario", "Rossi"));
		theStudent.add(new Student("Marry", "Smith"));
		return theStudent;
	}
	
	
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {
		//check valid range student id
		if(studentId >= theStudent.size() || studentId < 0 ) {
			throw new StudentNotFound("Student id is not available :"+studentId);
		}
		return theStudent.get(studentId);
	}
	
	
	
	
	
	
	
	
	
}