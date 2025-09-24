package com.tca.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="account")
public class Account 
{
	@Id
	@Column(name="accno")
	private Integer accNo;
	
	@Column(name="accholdername")
	private String accHolderName;
	
	@Column(name="acctype")
	private String accType;
	
	@Column(name="balance")
	private Float balance;

	public Integer getAccNo() {
		return accNo;
	}

	public void setAccNo(Integer accNo) {
		this.accNo = accNo;
	}

	public String getAccHolderName() {
		return accHolderName;
	}

	public void setAccHolderName(String accHolderName) {
		this.accHolderName = accHolderName;
	}

	public String getAccType() {
		return accType;
	}

	public void setAccType(String accType) {
		this.accType = accType;
	}

	public Float getBalance() {
		return balance;
	}

	public void setBalance(Float balance) {
		this.balance = balance;
	}
	
	
}
