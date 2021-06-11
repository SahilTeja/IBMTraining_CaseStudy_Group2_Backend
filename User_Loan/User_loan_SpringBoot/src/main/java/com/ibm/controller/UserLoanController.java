package com.ibm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.entity.User;
import com.ibm.entity.Admin;
import com.ibm.entity.Loan;
import com.ibm.entity.LoanStatus;
import com.ibm.service.UserLoanService;

/**
 * 
 * @author Harsh Anand
 *
 */

@CrossOrigin
@RestController
public class UserLoanController {
	
	@Autowired
	private UserLoanService Service;
	
//	@PostMapping(path = "/admin/save",consumes = "application/json")
//	public boolean saveAdmin(@RequestBody Admin admin) {
//		return Service.addAdmin(admin);
//	}
	@GetMapping(path = "/admin/find", produces = "application/json")
	public List<Admin> findAllAdmin(){
		return Service.findAllAdmin();
	}

	@PostMapping(path = "/adduser", consumes = "application/json")
	public int addUser(@RequestBody User user) {
		return Service.saveUser(user);
	}
	@GetMapping(path = "/finduser", produces = "application/json")
	public List<User> findAllUser(){
		return Service.findAllUser();
	}
	
	@PostMapping(path = "/addloan/{userId}", consumes = "application/json")
	public LoanStatus addLoan(@RequestBody Loan loan, @PathVariable("userId")int userId) {
		return Service.saveLoan(loan, userId);
	}
	
	@GetMapping(value = "/loanbyid/{loanId}", produces = "application/json")
	public Loan getLoanbyID(@PathVariable("loanId")int loanId) {
		return Service.getLoanbyID(loanId);
	}
	
	@GetMapping(value = "/userbyid/{userId}", produces = "application/json")
	public User getUserbyID(@PathVariable("userId")int userId) {
		return Service.getUserbyID(userId);
	}
	
	@GetMapping(value = "/loanbyuserId/{userId}", produces = "application/json")
	public List<Loan> getallLoanbyuserId(@PathVariable("userId")int userId) {
		return Service.getallLoanbyuserId(userId);
	}
	@GetMapping(value = "/loanbyloanId/{loanId}", produces = "application/json")
	public List<Loan> getallLoanbyloanId(@PathVariable("loanId")int loanId) {
		return Service.getallLoanbyloanId(loanId);
	}
	@GetMapping(value = "/loanbyname/{name}", produces = "application/json")
	public List<Loan> getallLoanbyName(@PathVariable("name")String name) {
		return Service.getallLoanbyName(name);
	}
	@GetMapping(path = "/findloanbyPending", produces = "application/json")
	public List<Loan> findLoanbyPendingApproval(){
		return Service.findLoanbyPendingApproval();
	}
	@GetMapping(path = "/findallloan", produces = "application/json")
	public List<Loan> findallloan(){
		return Service.findallloan();
	}
	
	@PutMapping(path = "/approve/{id}", produces = "application/json")
	public void approveLoan(@RequestBody Loan loan,@PathVariable("id") int id) {
		 Service.approveLoan(id);
	}
	
	@PutMapping(path = "/reject/{id}", produces = "application/json")
	public void rejectLoan(@RequestBody Loan loan,@PathVariable("id") int id) {
		 Service.rejectLoan(id);
	}
	@PutMapping(path = "/emiPay/{id}", produces = "application/json")
	public void EMIpayment(@RequestBody Loan loan,@PathVariable("id") int id) {
		 Service.EMIpayment(id);
	}
	
	@PutMapping(path = "/edit", produces = "application/json")
	public void editLoan(@RequestBody Loan loan) {
		 Service.editLoan(loan);
	}
	
	@PutMapping(path = "/updateProfile", produces = "application/json")
	public void updateProfile(@RequestBody User user) {
		 Service.updateProfile(user);
	}
	

}
