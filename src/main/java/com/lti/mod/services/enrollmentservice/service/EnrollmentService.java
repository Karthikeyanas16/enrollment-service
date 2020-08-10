package com.lti.mod.services.enrollmentservice.service;

import java.util.List;

import com.lti.mod.services.enrollmentservice.model.Enrollment;

public interface EnrollmentService {

	Object createEnrollment(Enrollment enrollemntdetails);

	void deleteEnrollment(Long id);

	List<Enrollment> getUserEnrollment(Long userId);

	List<Enrollment> findAllProposalSubmittedByUser(Long userId, String proposalStatus);
	List<Enrollment> findAllProposalSubmittedToMentor(Long userId, String proposalStatus);
	List<Enrollment> findAllUserMentor(Long userId);
	List<Enrollment> findAll();
	Enrollment updateEnrollmentStatus(Enrollment enrollemntdetails);

}
