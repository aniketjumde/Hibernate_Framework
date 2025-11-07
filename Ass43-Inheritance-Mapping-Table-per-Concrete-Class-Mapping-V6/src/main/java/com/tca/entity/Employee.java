package com.tca.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;


@Entity(name="EMP5")
public class Employee extends Person
{
	@Column(name="esalary")
	private Double salary;

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}
	
	
	
}
