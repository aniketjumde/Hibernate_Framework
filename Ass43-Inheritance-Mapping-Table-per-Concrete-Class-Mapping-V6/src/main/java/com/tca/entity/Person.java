package com.tca.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity(name="Person")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Person 
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
