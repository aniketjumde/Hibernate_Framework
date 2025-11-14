package com.tca.entities;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="StudentCourse")
public class StudentCourse 
{
	@Id
	private int id;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="FK_rno")
	private Student student;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="FK_cid")
	private Course course;
	
	@Column(name="REG_DATE")
	LocalDate regdate;		//Descriptive Attribute

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public LocalDate getRegdate() {
		return regdate;
	}

	public void setRegdate(LocalDate regdate) {
		this.regdate = regdate;
	}
	
	

}
