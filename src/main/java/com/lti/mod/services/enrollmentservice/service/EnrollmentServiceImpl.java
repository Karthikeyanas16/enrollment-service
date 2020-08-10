package com.lti.mod.services.enrollmentservice.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

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
	public List<Enrollment> findAllProposalSubmittedByUser(Long userId, String proposalStatus) {
		return enrollmentRepository.findAllProposalSubmittedByUser(userId, proposalStatus);
	}
	@Override
	public List<Enrollment> findAllProposalSubmittedToMentor(Long userId, String proposalStatus) {
		return enrollmentRepository.findAllProposalSubmittedToMentor(userId, proposalStatus);
	}
	@Override
	public List<Enrollment> findAllUserMentor(Long userId) {
		return enrollmentRepository.findAllUserMentor(userId);
	}
	@Override
	public List<Enrollment> findAll() {
		return (List<Enrollment>) enrollmentRepository.findAll();
	}

	@Override
	public Enrollment updateEnrollmentStatus(Enrollment enrollemntdetails) {
		Optional<Enrollment> enrollmentOption = enrollmentRepository.findById(enrollemntdetails.getId());
		Enrollment  existingEnrol = enrollmentOption.get();
		existingEnrol.setProposalStatus(enrollemntdetails.getProposalStatus());
		return enrollmentRepository.save(existingEnrol);
	}
}
