package com.tca.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="student")
public class Student 
{
	@Id 
	private Integer rno;
	private String name;
	private Double per;
	
	transient private String grade;  //Transient DataMember 
	
	
	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	
	/*
	 * If the dataBase side Have 4 colum rno name per Grade  But user can pass only three value 
	 * then DataBase side create a trigger give percentage wise Grade By inert a Query
	 */

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
