package com.tca.entity;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="course")
public class Course 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Cid")
	private Integer cid;
	
	@Column(name="Cname")
	private String cname;
	
	@Column(name="CourseFees")
	private Double cfees;
	
	@Column(name="Creation_Date")
	@CreationTimestamp
	private LocalDateTime createdDate;
	
	
	@Column(name="Updation_Date")
	@UpdateTimestamp
	private LocalDateTime updateDate;

	@OneToMany(mappedBy="course",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private List<Registration> registration;

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public Double getCfees() {
		return cfees;
	}

	public void setCfees(Double cfees) {
		this.cfees = cfees;
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

	public List<Registration> getRegistration() {
		return registration;
	}

	public void setRegistration(List<Registration> registration) {
		this.registration = registration;
	}
	
	
	
}
