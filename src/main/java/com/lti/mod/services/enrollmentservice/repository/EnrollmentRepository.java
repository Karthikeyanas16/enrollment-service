package com.lti.mod.services.enrollmentservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.lti.mod.services.enrollmentservice.model.Enrollment;


public interface EnrollmentRepository extends CrudRepository<Enrollment, Long>{


	@Query(value = "select * from Enrollment e where e.user_id = ?1", nativeQuery = true)
	List<Enrollment> findAllbyUserId(Long userId);
	
	@Query(value = "select * from Enrollment e where e.user_id = ?1 and e.proposal_Status=?2", nativeQuery = true)
	List<Enrollment> findAllProposalSubmittedByUser(Long userId, String proposalStatus);



}
