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
import com.ibm.entity.Cibil;
import com.ibm.entity.EMIChart;
import com.ibm.entity.Loan;
import com.ibm.service.UserLoanService;


@CrossOrigin
@RestController
public class UserLoanController {
	
	@Autowired
	private UserLoanService Service;
	
	@PostMapping(path = "/admin/save",consumes = "application/json")
	public boolean saveAdmin(@RequestBody Admin admin) {
		return Service.addAdmin(admin);
	}
	@GetMapping(path = "/admin/find", produces = "application/json")
	public List<Admin> findAllAdmin(){
		return Service.findAllAdmin();
	}
	@PostMapping(path = "/cibil/save",consumes = "application/json")
	public boolean saveCibil(@RequestBody Cibil cibil) {
		return Service.addCibilScore(cibil);
	}
	@GetMapping(path = "/cibil/find", produces = "application/json")
	public List<Cibil> findallCibil(){
		return Service.findAllCibil();
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
	public int addLoan(@RequestBody Loan loan, @PathVariable("userId")int userId) {
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
	
	@PutMapping(path = "/approve/{id}/{comment}", produces = "application/json")
	public void approveLoan(@RequestBody Loan loan,@PathVariable("id") int id,@PathVariable("comment") String comment) {
		 Service.approveLoan(id,comment);
	}
	
	@PutMapping(path = "/reject/{id}/{comment}", produces = "application/json")
	public void rejectLoan(@RequestBody Loan loan,@PathVariable("id") int id,@PathVariable("comment") String comment) {
		 Service.rejectLoan(id,comment);
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
	
	@PostMapping(path = "/OTP/{loanId}/{otp}",produces = "application/json")
	public void sendOtp(@PathVariable("loanId") int loanId, @PathVariable("otp") int otp,@RequestBody Loan loan) {
		System.out.println("============================================================="+loanId);
		Service.sendOtpMail(otp,loanId);
	}
	@PostMapping(path = "/forgetPassword/{userid}/{password}",produces = "application/json")
	public void forgetPassword(@PathVariable("userid") int userid,@PathVariable("password") String password, @RequestBody Loan loan) {
		System.out.println("============================================================="+userid);
		Service.forgetPassword(userid,password);
	}
	@PostMapping(path = "/loanComplete/{loanid}",produces = "application/json")
	public void LoanCompletition(@PathVariable("loanid") int loanid, @RequestBody Loan loan) {
		System.out.println("============================================================="+loanid);
		Service.LoanCompletition(loanid);
	}
	
	@GetMapping(value = "/emichart/{principal}/{rate}/{interest}", produces = "application/json")
	public List<EMIChart> getEmi(@PathVariable("principal")double principal, @PathVariable("rate")double rate, @PathVariable("interest")double interest) {
		return Service.getEmichart(principal,rate,interest);
	}

}
