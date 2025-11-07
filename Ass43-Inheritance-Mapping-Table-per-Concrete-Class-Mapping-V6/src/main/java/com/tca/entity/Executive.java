package com.tca.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity(name="EXE5")
public class Executive extends Person
{
	@Column(name="erole")
	private String role;
	
	@Column(name="ebonus")
	private Double bonus;

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Double getBonus() {
		return bonus;
	}

	public void setBonus(Double bonus) {
		this.bonus = bonus;
	}
	
	
	
	
	
}
