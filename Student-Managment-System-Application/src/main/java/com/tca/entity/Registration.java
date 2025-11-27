package com.tca.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Registration")
public class Registration 
{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="RegistrationID")
	private Integer rid;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="FK_sid")
	private Student student;
	
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="FK_cid")
	private Course course;
	
	
	@Column(name="Registration_Date")
	private LocalDate regdate;  //Descriptive Attribute

	@Column(name="Creation_Date")
	@CreationTimestamp
	private LocalDateTime createdDate;
	
	
	@Column(name="Updation_Date")
	@UpdateTimestamp
	private LocalDateTime updateDate;


	public Integer getRid() {
		return rid;
	}


	public void setRid(Integer rid) {
		this.rid = rid;
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


	public LocalDateTime getCreatedDate() {
		return createdDate;
	}


	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}


	public LocalDateTime getUpdateDate() {
		return updateDate;
	}


	public void setUpdateDate(LocalDateTime updateDate) {
		this.updateDate = updateDate;
	}
	
	
}
