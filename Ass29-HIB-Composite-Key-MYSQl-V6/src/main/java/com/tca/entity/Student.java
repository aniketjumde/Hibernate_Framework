package com.tca.entity;

import jakarta.persistence.Embedded;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="student")
public class Student 
{
	@EmbeddedId
	private StudentCompositeKey studentCompositeKey;
	private String city;
	public StudentCompositeKey getStudentCompositeKey() {
		return studentCompositeKey;
	}
	public void setStudentCompositeKey(StudentCompositeKey studentCompositeKey) {
		this.studentCompositeKey = studentCompositeKey;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	

}
