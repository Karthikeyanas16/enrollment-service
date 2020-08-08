package com.lti.mod.services.enrollmentservice.service;

import java.math.BigInteger;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.mod.services.enrollmentservice.model.Enrollment;
import com.lti.mod.services.enrollmentservice.repository.EnrollmentRepository;

@Service
@Transactional
public class EnrollmentServiceImpl  implements EnrollmentService{

	@Autowired
	EnrollmentRepository enrollmentRepository;

	@Override
	public Enrollment createEnrollment(Enrollment enrollemntdetails) {
		
		return enrollmentRepository.save(enrollemntdetails);
	}

	@Override
	public void deleteEnrollment(Long id) {
		enrollmentRepository.deleteById(id);
	}

	@Override
	public List<Enrollment> getUserEnrollment(Long userId) {
		return enrollmentRepository.findAllbyUserId(userId);
	}

	@Override
	public List<Enrollment> findAllProposalSubmittedByUSer(Long userId, String proposalStatus) {
		return enrollmentRepository.findAllProposalSubmittedByUser(userId, proposalStatus);
	}
	
	
}
