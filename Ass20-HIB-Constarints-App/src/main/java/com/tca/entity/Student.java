package com.tca.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Rscoe_Student")  
public class Student 
{
	@Id
	@Column(name="Roll_no")  
	private Integer rno;
	
	@Column(name="Full_name",length=50,nullable=false) 
	private String name;
	
	@Column(name="Percentage",columnDefinition="Double Check(Percentage>=0 AND Percentage<=100)") 
	private Double per;
	
	@Column(name="Email",length=20,unique=true,nullable=false)
	private String email;
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
