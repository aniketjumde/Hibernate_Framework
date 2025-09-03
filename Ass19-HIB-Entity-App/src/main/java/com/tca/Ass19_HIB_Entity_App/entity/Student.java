package com.tca.Ass19_HIB_Entity_App.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Rscoe_Student")  /* This Table Annotation is Optional The User Want to Class 
						Name and Table name Will be Same Doesnt Requiredt To give the Annotation
						But User Want to Give Different name Of table thats time Annotation Will be Reiqured */
public class Student 
{
	@Id
	@Column(name="Roll_no")  /* This Table Annotation is Optional The User Want to Class 
	Name and Table name Will be Same Doesnt Requiredt To give the Annotation
	But User Want to Give Different name Of table thats time Annotation Will be Reiqured */
	private Integer rno;
	@Column(name="Full_name") /*This is Optional */
	private String name;
	@Column(name="Percentage") /*This is Optional */
	private Double per;
	
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
