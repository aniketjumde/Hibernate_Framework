package com.tca.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table(name="student")

@NamedQueries(
		 value= {
				 
				 @NamedQuery(name="GET_ALL_INFO",query="FROM Student"),
				 @NamedQuery(name="GET_CITYWISE",query="FROM Student Where city=:fcity"),
				 @NamedQuery(name="MODIFY_STUDENT_INFO",query="UPDATE Student SET city=:newcity WHERE city=:oldcity"),
				 @NamedQuery(name="REMOVE_STUDENT",query="DELETE FROM Student WHERE rno=:rollNumber")
				 
		 		}
		)
public class Student 
{
	@Id
	@Column(name="srno")
	private Integer rno;
	
	@Column(name="sname")
	private String name;
	
	@Column(name="sper")
	private Double per;
	
	@Column(name="scity")
	private String city;

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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	
	
}
