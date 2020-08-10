package com.lti.mod.services.enrollmentservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.mod.services.enrollmentservice.model.Enrollment;
import com.lti.mod.services.enrollmentservice.model.Technology;
import com.lti.mod.services.enrollmentservice.model.User;
import com.lti.mod.services.enrollmentservice.proxy.UserProxy;
import com.lti.mod.services.enrollmentservice.service.EnrollmentService;

import javassist.NotFoundException;

@RestController
public class EnrollmentController {
	
	@Autowired
	EnrollmentService enrollmentService;
	
	
	@Autowired
	private UserProxy proxy;
	
	@PostMapping("/create")
    public ResponseEntity<?> createEnrollment(@RequestBody Enrollment enrollemntdetails) throws NotFoundException {
		
		if (enrollemntdetails == null)
			throw new NotFoundException("Enrollment Details not found");
			
		User studentUser = proxy.findUserbyId(enrollemntdetails.getUser_id());
		if(studentUser == null) 
			throw new NotFoundException("Student User details not found");
		
		User mentorUser = proxy.findUserbyId(enrollemntdetails.getMentor_id());
		if(mentorUser == null) 
			throw new NotFoundException("Mentor User details not found");
		
		Technology technology = proxy.findTechnologybyId(enrollemntdetails.getTechnology_id());
		if(technology == null)
			throw new NotFoundException("Technology details not found");
		
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
		
		if(userId == 0)
			throw new NotFoundException("User not found");
		
		 return new ResponseEntity<>(enrollmentService.getUserEnrollment(userId), HttpStatus.CREATED);
    }

	@GetMapping("/search/{userId}/{proposalStatus}")
	public ResponseEntity<?> findAllProposalSubmittedByUSer(@PathVariable Long userId, @PathVariable String proposalStatus) throws NotFoundException {
		if(userId == 0)
			throw new NotFoundException("User id not found");

		List<Enrollment> enrollments = enrollmentService.findAllProposalSubmittedByUser(userId, proposalStatus);

		for (Enrollment enrollment : enrollments) {
			User user = proxy.findUserbyId(enrollment.getUser_id());
			if(user!=null)
				enrollment.setUsername(user.getName());

			User mentor = proxy.findUserbyId(enrollment.getMentor_id());
			if(mentor!=null)
				enrollment.setMentorname(mentor.getName());

			Technology technology = proxy.findTechnologybyId(enrollment.getTechnology_id());
			if(technology!= null)
				enrollment.setTechnology(technology.getTechnology());
			enrollment.setDescription(technology.getDescription());
		}

		return new ResponseEntity<>(enrollments, HttpStatus.CREATED);
	}
	@GetMapping("/search/mentor/{userId}/{proposalStatus}")
	public ResponseEntity<?> findAllProposalSubmitedToMentor(@PathVariable Long userId, @PathVariable String proposalStatus) throws NotFoundException {
		if(userId == 0)
			throw new NotFoundException("User id not found");

		List<Enrollment> enrollments = enrollmentService.findAllProposalSubmittedToMentor(userId, proposalStatus);

		for (Enrollment enrollment : enrollments) {
			User user = proxy.findUserbyId(enrollment.getUser_id());
			if(user!=null)
				enrollment.setUsername(user.getName());

			User mentor = proxy.findUserbyId(enrollment.getMentor_id());
			if(mentor!=null)
				enrollment.setMentorname(mentor.getName());

			Technology technology = proxy.findTechnologybyId(enrollment.getTechnology_id());
			if(technology!= null)
				enrollment.setTechnology(technology.getTechnology());
			enrollment.setDescription(technology.getDescription());
		}

		return new ResponseEntity<>(enrollments, HttpStatus.CREATED);
	}
	@GetMapping("/search/mentor/enrolled/{userId}")
	public ResponseEntity<?> findAllUserMentor(@PathVariable Long userId) throws NotFoundException {
		if(userId == 0)
			throw new NotFoundException("User id not found");

		List<Enrollment> enrollments = enrollmentService.findAllUserMentor(userId);

		for (Enrollment enrollment : enrollments) {
			User user = proxy.findUserbyId(enrollment.getUser_id());
			if(user!=null)
				enrollment.setUsername(user.getName());

			User mentor = proxy.findUserbyId(enrollment.getMentor_id());
			if(mentor!=null)
				enrollment.setMentorname(mentor.getName());

			Technology technology = proxy.findTechnologybyId(enrollment.getTechnology_id());
			if(technology!= null)
				enrollment.setTechnology(technology.getTechnology());
			enrollment.setDescription(technology.getDescription());
		}

		return new ResponseEntity<>(enrollments, HttpStatus.CREATED);
	}
	@GetMapping("/search/user/enrolled/{userId}")
	public ResponseEntity<?> getAllTechnologiesForUser(@PathVariable Long userId){
		
		List<Enrollment> enrollments = null;
		List<Enrollment> enrolled = enrollmentService.getUserEnrollment(userId);
		
		if(CollectionUtils.isEmpty(enrolled)) {
			return ResponseEntity.notFound().build();
		}
		
		enrollments = new ArrayList<Enrollment>();
		for(Enrollment enrollment:enrolled) {
			Technology tech = proxy.findTechnologybyId(enrollment.getTechnology_id());
			User studentUser = proxy.findUserbyId(userId);
			User mentorUser = proxy.findUserbyId(enrollment.getMentor_id());
			enrollment.setUsername(studentUser.getName());
			enrollment.setMentorname(mentorUser.getName());
			enrollment.setTechnology(tech.getTechnology());
			enrollment.setDescription(tech.getDescription());
			enrollment.setFees(tech.getFees());
			enrollments.add(enrollment);
		}
		
		return new ResponseEntity<>(enrollments, HttpStatus.OK);
		
	}

	@GetMapping("/findall")
    public ResponseEntity<?> getAllEnrollements() throws NotFoundException {
		
		List<Enrollment> enrollments = enrollmentService.findAll();
		
		for (Enrollment enrollment : enrollments) {
			User user = proxy.findUserbyId(enrollment.getUser_id());
			if(user!=null)
				enrollment.setUsername(user.getEmail());
			
			User mentor = proxy.findUserbyId(enrollment.getMentor_id());
			if(mentor!=null)
				enrollment.setMentorname(mentor.getEmail());
			
			Technology technology = proxy.findTechnologybyId(enrollment.getTechnology_id());
			if(technology!= null)
				enrollment.setTechnology(technology.getTechnology());

		}
		
		return new ResponseEntity<>(enrollments, HttpStatus.CREATED);
    }
}
