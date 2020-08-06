package com.lti.mod.services.enrollmentservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.mod.services.enrollmentservice.model.Enrollment;
import com.lti.mod.services.enrollmentservice.service.EnrollmentService;

import javassist.NotFoundException;

@RestController
public class EnrollmentController {
	
	@Autowired
	EnrollmentService enrollmentService;
	
	@PostMapping("/create")
    public ResponseEntity<?> createEnrollment(@RequestBody Enrollment enrollemntdetails) throws NotFoundException {
		
		if (enrollemntdetails == null) {
			throw new NotFoundException("Enrollment Details not found");
		} 
		
		 return new ResponseEntity<>(enrollmentService.createEnrollment(enrollemntdetails), HttpStatus.CREATED);
    }
	
	@GetMapping("/delete/{id}")
    public ResponseEntity<?> deleteEnrollment(@PathVariable Long id) throws NotFoundException {
			if(id == 0)
				throw new NotFoundException("Enrollment id not found");
		 enrollmentService.deleteEnrollment(id);
		 return new ResponseEntity<>(HttpStatus.CREATED);
    }
	
	@GetMapping("/search/{userId}")
    public ResponseEntity<?> findEnrollment(@PathVariable Long userId) throws NotFoundException {
		System.out.println("### Inside create Enrollment");
		
		if(userId == 0)
			throw new NotFoundException("User id not found");
		
		 return new ResponseEntity<>(enrollmentService.getUserEnrollment(userId), HttpStatus.CREATED);
    }
}