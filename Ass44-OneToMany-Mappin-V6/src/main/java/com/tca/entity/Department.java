package com.tca.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="DEPT")
public class Department 
{
	@Id
	private Integer did;
	private String dname;
	
	
	@OneToMany(mappedBy="dept",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	List<Employee> emps_list;


	public Integer getDid() {
		return did;
	}


	public void setDid(Integer did) {
		this.did = did;
	}


	public String getDname() {
		return dname;
	}


	public void setDname(String dname) {
		this.dname = dname;
	}


	public List<Employee> getEmps_list() {
		return emps_list;
	}


	public void setEmps_list(List<Employee> emps_list) {
		this.emps_list = emps_list;
	}
	
	
}
