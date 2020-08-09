package com.lti.mod.services.enrollmentservice.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Data;

@Data
@Entity
@Table(name="Enrollment")
public class Enrollment implements Serializable{
	/**
	 * Default Serial version UID
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
    @Column
    private Long user_id;
    @Column
    private Long mentor_id;
    @Column
    private Long technology_id;
    @Column
    private String comments;
    @Column
    private Long proposalAmount;
    @Column
    private String proposalStatus;
    
    @Transient
    private String technology;
    
    @Transient
    private String description;
    
    @Transient
    private int fees;
    
    @Transient
    private String username;

    
    @Transient
    private String mentorname;
    
    public Enrollment() {}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Long getUser_id() {
		return user_id;
	}


	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	
	public Long getMentor_id() {
		return mentor_id;
	}


	public void setMentor_id(Long mentor_id) {
		this.mentor_id = mentor_id;
	}


	public Long getTechnology_id() {
		return technology_id;
	}


	public void setTechnology_id(Long technology_id) {
		this.technology_id = technology_id;
	}


	public String getComments() {
		return comments;
	}


	public void setComments(String comments) {
		this.comments = comments;
	}


	public Long getProposalAmount() {
		return proposalAmount;
	}


	public void setProposalAmount(Long proposalAmount) {
		this.proposalAmount = proposalAmount;
	}


	public String getProposalStatus() {
		return proposalStatus;
	}


	public void setProposalStatus(String proposalStatus) {
		this.proposalStatus = proposalStatus;
	}


	public String getTechnology() {
		return technology;
	}


	public void setTechnology(String technology) {
		this.technology = technology;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public int getFees() {
		return fees;
	}


	public void setFees(int fees) {
		this.fees = fees;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getMentorname() {
		return mentorname;
	}


	public void setMentorname(String mentorname) {
		this.mentorname = mentorname;
	}

	
    
    

}
