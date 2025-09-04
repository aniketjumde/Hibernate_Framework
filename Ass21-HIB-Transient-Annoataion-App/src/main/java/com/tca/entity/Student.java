package com.tca.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

@Entity
public class Student 
{
	@Id 
	private Integer rno;
	private String name;
	private Double per;
	@Transient
	private Integer age;
	
	/*
	 * If i want to Store three field in DataBase but 4th filed not store in dataBase this filed required 
	 * in java code In that Condition You can use the "@transient" Annotation 
	 */
	

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Student() {}

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

	public Double getPer() {
		return per;
	}

	public void setPer(Double per) {
		this.per = per;
	}
	
	
}
