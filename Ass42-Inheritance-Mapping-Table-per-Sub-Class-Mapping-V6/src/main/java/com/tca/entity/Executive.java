package com.tca.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity(name="EXE3")
@PrimaryKeyJoinColumn(name="eid")
public class Executive extends Employee
{
	
	@Column(name="erole")
	private String role;

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
	
}
