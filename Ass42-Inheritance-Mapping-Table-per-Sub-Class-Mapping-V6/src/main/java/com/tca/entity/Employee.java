package com.tca.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity(name="Emp3")
@Inheritance(strategy=InheritanceType.JOINED)
public class Employee 
{

	@Id
	@Column(name="eid")
	private Integer id;
	
	
	@Column(name="ename")
	private String name;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
}
