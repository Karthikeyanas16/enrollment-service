package com.lti.mod.services.enrollmentservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.lti.mod.services.enrollmentservice.model.Enrollment;


public interface EnrollmentRepository extends CrudRepository<Enrollment, Long>{


	@Query(value = "select * from Enrollment e where e.user_id = ?1", nativeQuery = true)
	List<Enrollment> findAllbyUserId(Long userId);

	@Query(value = "select u.id as user_id, u.name as username,u.role, e.comments,e.mentor_id,e.proposal_Amount,e.proposal_Status,e.technology_id,t.id,t.technology,t.description,t.Fees from user u join enrollment e on u.id=e.user_id \n" +
			"join technology t on t.id=e.technology_id where e.user_id=?1 and e.proposal_Status=?2", nativeQuery = true)
	List<Enrollment> findAllProposalSubmittedByUser(Long userId, String proposalStatus);

	@Query(value = "select u.id, u.name,u.role,e.user_id, e.comments,e.mentor_id,e.proposal_Amount,e.proposal_Status,e.technology_id,t.id,t.technology,t.description,t.Fees from user u join enrollment e on u.id=e.user_id join technology t on t.id=e.technology_id where e.mentor_id=?1 and e.proposal_Status=?2", nativeQuery = true)
	List<Enrollment> findAllProposalSubmittedToMentor(Long userId, String proposalStatus);

	@Query(value = "select u.id, u.name,u.role,e.user_id, e.comments,e.mentor_id,e.proposal_Amount,e.proposal_Status,e.technology_id,t.id,t.technology,t.description,t.Fees from user u join enrollment e on u.id=e.user_id join technology t on t.id=e.technology_id where e.mentor_id=?1", nativeQuery = true)
	List<Enrollment> findAllUserMentor(Long userId);

}
