package com.ibm.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;
/**
 * 
 * @author Harsh Anand
 *
 */
@Entity
public class User {
	
	@Id
	@GeneratedValue
	private int userId;
	
	private String password;
	
	private String name;
	
//	@Column(unique = true)
	private String email;
	
	@Column(unique = true)
	private String aadhar;
	
	@Column(unique = true)
	private String panCard;
	
	private int salary;
	
	@Column(unique = true)
	private String mobilenumber;
	
	private String aadress;
	
	private String country="India";
	
	private String state;

	@JsonManagedReference
	@OneToMany(mappedBy = "user")
	private List<Loan> loans;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public String getMobilenumber() {
		return mobilenumber;
	}

	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}

	public String getAadress() {
		return aadress;
	}

	public void setAadress(String aadress) {
		this.aadress = aadress;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public List<Loan> getLoans() {
		return loans;
	}

	public void setLoans(List<Loan> loans) {
		this.loans = loans;
	}

	
	
}
