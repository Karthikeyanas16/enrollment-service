package com.lti.mod.services.enrollmentservice.model;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;



public class User implements Serializable{
	/**
	 * Default Serial version UID
	 */
	private static final long serialVersionUID = 1L;
	
	
    private int id;
    private String name;
    private String email;
    private String password;
    private String role;
    private int technology_id;
    private int status;
    
	public User() {

	}
    
	public User(String name, String email, String password, String role, int technology_id, int status) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.role = role;
		this.technology_id = technology_id;
		this.status = status;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public int getTechnology_id() {
		return technology_id;
	}
	public void setTechnology_id(int technology_id) {
		this.technology_id = technology_id;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", role=" + role
				+ ", technology_id=" + technology_id + ", status=" + status + "]";
	}
    
    
    

}
