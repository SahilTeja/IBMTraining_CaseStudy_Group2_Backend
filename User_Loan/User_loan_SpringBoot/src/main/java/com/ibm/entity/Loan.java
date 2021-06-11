package com.ibm.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
/**
 * 
 * @author Harsh Anand
 *
 */
@Entity
public class Loan {
	
	@Id
	@GeneratedValue
	private int loanId; 
	
	private String name;
	private String email;
	private String aadhar;
	private String panCard;
	private int amount;
	private int duration;
	private String emiCompleted="No";
	private String status = "Pending";

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "user_id")  //foreign key
	private User user;

	public int getLoanId() {
		return loanId;
	}

	public void setLoanId(int loanId) {
		this.loanId = loanId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAadhar() {
		return aadhar;
	}

	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
	}

	public String getPanCard() {
		return panCard;
	}

	public void setPanCard(String panCard) {
		this.panCard = panCard;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getEmiCompleted() {
		return emiCompleted;
	}

	public void setEmiCompleted(String emiCompleted) {
		this.emiCompleted = emiCompleted;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
