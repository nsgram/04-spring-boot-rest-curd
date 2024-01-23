package com.capgemini.demo.expectionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.capgemini.demo.entity.StudentErrorResponse;
import com.capgemini.demo.exceptions.StudentNotFound;
@ControllerAdvice
public class StudentRestExpectionHandler {
	
	//add exception handler
		@ExceptionHandler
		public ResponseEntity<StudentErrorResponse> handleException(StudentNotFound exp){
			//create error response
			
			StudentErrorResponse error = new StudentErrorResponse();
			
			error.setStatus(HttpStatus.NOT_FOUND.value());
			error.setMessage(exp.getMessage());
			error.setTimeStamp(System.currentTimeMillis());
			
			return new ResponseEntity<StudentErrorResponse>(error,HttpStatus.NOT_FOUND);
			
			
		}
		//add new exception generic handler
		@ExceptionHandler
		public ResponseEntity<StudentErrorResponse> handleException(Exception exp){
		
			//create error response
			
					StudentErrorResponse error = new StudentErrorResponse();
					
					error.setStatus(HttpStatus.BAD_REQUEST.value());
					error.setMessage(exp.getMessage());
					error.setTimeStamp(System.currentTimeMillis());
					
					return new ResponseEntity<StudentErrorResponse>(error,HttpStatus.BAD_REQUEST);
					
		
		}

}
