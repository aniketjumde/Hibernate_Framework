package com.tca.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Student")
public class Student 
{
	
	@Id
	private Integer rno;
	private String name;
	
	@OneToMany(mappedBy="student",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private List<StudentCourse> regis;

	public Integer getRno() {
		return rno;
	}

	public void setRno(Integer rno) {
		this.rno = rno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<StudentCourse> getRegis() {
		return regis;
	}

	public void setRegis(List<StudentCourse> regis) {
		this.regis = regis;
	}
	
	
	
}




