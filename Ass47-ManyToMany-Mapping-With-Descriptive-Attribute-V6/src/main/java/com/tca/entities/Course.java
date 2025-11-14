package com.tca.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Course")
public class Course 
{
	@Id
	private Integer cid;
	private String cname;
	
	@OneToMany(mappedBy="course",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private List<StudentCourse> regis;

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

	public List<StudentCourse> getRegis() {
		return regis;
	}

	public void setRegis(List<StudentCourse> regis) {
		this.regis = regis;
	}
	
	
}
