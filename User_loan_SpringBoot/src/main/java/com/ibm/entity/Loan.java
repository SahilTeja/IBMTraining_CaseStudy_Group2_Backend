package com.ibm.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Loan {
	
	@Id
	@GeneratedValue
	private int loanId;
	
	private String name;
	private String email;
	private String aadhar;
	private String panCard;
	private LocalDate dateofbirth;
	private double salary;
	private double amount;
	private double duration;
	private double interest;
	private String emiCompleted="No";
	private String status = "Pending";
	private String comment="Loan Applied";

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "user_id")  //foreign key
	private User user;

	

	public Loan() {
		super();
	}
	
	public Loan(String name, String aadhar, String panCard, double salary, double amount, double duration) {
		this.name = name;
		this.aadhar = aadhar;
		this.panCard = panCard;
		this.salary = salary;
		this.amount = amount;
		this.duration = duration;
	}

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

	public LocalDate getDateofbirth() {
		return dateofbirth;
	}

	public void setDateofbirth(LocalDate dateofbirth) {
		this.dateofbirth = dateofbirth;
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

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getDuration() {
		return duration;
	}

	public void setDuration(double duration) {
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

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public double getInterest() {
		return interest;
	}

	public void setInterest(double interest) {
		this.interest = interest;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
}
