package com.lti.mod.services.enrollmentservice.service;

import java.util.List;

import com.lti.mod.services.enrollmentservice.model.Enrollment;

public interface EnrollmentService {

	Object createEnrollment(Enrollment enrollemntdetails);

	void deleteEnrollment(Long id);

	List<Enrollment> getUserEnrollment(Long userId);
	
	List<Enrollment> findAllProposalSubmittedByUSer(Long userId, String proposalStatus);

	List<Enrollment> findAll();

}
