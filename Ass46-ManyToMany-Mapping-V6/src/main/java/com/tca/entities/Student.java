package com.tca.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Student")
public class Student 
{
	@Id
	private Integer rno;
	private String name;
	
	@ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinTable(
				name="Student_Course",
				joinColumns=@JoinColumn(name="FK_Id"),
				inverseJoinColumns=@JoinColumn(name="Fk_cid")
			)
	List<Course> course;

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

	public List<Course> getCourse() {
		return course;
	}

	public void setCourse(List<Course> course) {
		this.course = course;
	}
	
	
	
	
}




/*
 * 
 * 
 * if The Both Entity Class is Konow about Relationship is Called as Bidirectional Many-to-Many Relationship
	
	Above Both Entity class is konow to relationship that is the Bidirectional RealtionShip
	
	
	If the Only One Class is Known about the relationship this is called as the Unidiredtional RelationShip 
*/