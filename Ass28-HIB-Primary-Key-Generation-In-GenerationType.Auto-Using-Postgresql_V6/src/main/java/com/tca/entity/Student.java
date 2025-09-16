package com.tca.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.TableGenerator;

@Entity
public class Student 
{
//	@Id
//	@GeneratedValue(strategy=GenerationType.SEQUENCE)
//	private int rno;
//	private String name;
//	private Double per;
	
	@Id
	@TableGenerator(name="tg",table="mytab",pkColumnName="myid",pkColumnValue="101",valueColumnName="next_hi",initialValue=500,allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="tg")
	private int rno;
	private String name;
	private Double per;
	
	
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
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
