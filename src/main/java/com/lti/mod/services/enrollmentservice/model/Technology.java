package com.lti.mod.services.enrollmentservice.model;

import java.math.BigInteger;

public class Technology{

    private BigInteger id;
    private String technology;
    private String description;
    private String Status;
    private int Fees;
    
	public Technology() {
	}
	
	
	public Technology(String technology, String description, String status, int fees) {
		this.technology = technology;
		this.description = description;
		Status = status;
		Fees = fees;
	}


	public BigInteger getId() {
		return id;
	}
	public void setId(BigInteger id) {
		this.id = id;
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
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public int getFees() {
		return Fees;
	}
	public void setFees(int fees) {
		Fees = fees;
	}
    
    

}
