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
@Table(name="student")
public class Student 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer rno;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="PER")
	private Double per;
	
	@Column(name="CITY")
	private String city;
	
	@Column(name="DATE_CREATED")
	@CreationTimestamp
	private LocalDateTime dateCreated;
	
	@Column(name="DATE_UPDATED")
	@UpdateTimestamp
	private LocalDateTime lastUpdated;

	
	@OneToMany(mappedBy="student",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private List<Registration> registration;
	
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

	public LocalDateTime getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(LocalDateTime dateCreated) {
		this.dateCreated = dateCreated;
	}

	public LocalDateTime getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(LocalDateTime lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public List<Registration> getRegistration() {
		return registration;
	}

	public void setRegistration(List<Registration> registration) {
		this.registration = registration;
	}
	
	
}
