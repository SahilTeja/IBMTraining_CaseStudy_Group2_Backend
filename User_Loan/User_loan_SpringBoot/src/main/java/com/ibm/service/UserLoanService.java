package com.ibm.service;

import java.util.List;

/**
 * 
 * @author Harsh Anand
 *
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.entity.User;
import com.ibm.entity.Admin;
import com.ibm.entity.Loan;
import com.ibm.entity.LoanStatus;
import com.ibm.repos.UserRepository;
import com.ibm.repos.AdminRepository;
import com.ibm.repos.LoanRepository;

@Service
public class UserLoanService {
	
	@Autowired
	private LoanRepository loanRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private AdminRepository adminRepo;
	
	
//	public boolean addAdmin(Admin admin) {
//		return adminRepo.save(admin)!=null?true:false;
//	}
	public List<Admin> findAllAdmin(){
		return adminRepo.findAll();
	}
	
	
	public int saveUser(User user) {
		userRepo.save(user);
		return user.getUserId();
	}
	
	public LoanStatus saveLoan(Loan loan,int userId) {
		List<Loan> list = getallLoanbyuserId(userId);
		String emiCompleted = "Yes";
		String status = "Pending";
		for(Loan loan1:list) {
			 emiCompleted = loan1.getEmiCompleted();
			 status = loan1.getStatus();		 
		}
		System.out.println("======="+emiCompleted+"========="+status);
		LoanStatus loanstatus = new LoanStatus();
		if((emiCompleted.equals("Yes")) || status.equals("Rejected")) {
			User user = getUserbyID(userId);
			loan.setUser(user);
				
			loanRepo.save(loan);
			loanstatus.setStatus(loan.getLoanId());
			return loanstatus;
		}
		
		else {
			loanstatus.setStatus(0);
			return loanstatus;
		}	
			
	}
	
	public Loan getLoanbyID(int loanId) {
		return loanRepo.findById(loanId).get();
	}
	
	public User getUserbyID(int userId) {
		return userRepo.findById(userId).get();
	}
	
	public List<Loan> getallLoanbyuserId(int userId) {
		return loanRepo.findByUserId(userId);
	}
	public List<Loan> getallLoanbyloanId(int loanId) {
		return loanRepo.findByLoanId(loanId);
	}
	public List<Loan> getallLoanbyName(String name) {
		return loanRepo.findLoanByName(name);
	}

	public List<User> findAllUser() {
		return userRepo.findAll();
	}
	
	public List<Loan> findLoanbyPendingApproval() {   //whose Emi not completed & status is pending
		return loanRepo.findLoanbyPendingApproval();
	}
	public List<Loan> findallloan() {   
		return loanRepo.findAll();
	}
	
	public void approveLoan(int id) {
		 loanRepo.approveLoan(id);
	}

	public void rejectLoan(int id) {
		loanRepo.rejectLoan(id);
	}
	
	public void EMIpayment(int id) {
		loanRepo.EMIpayment(id);
	}
	
	public void editLoan(Loan loan) {
		loanRepo.editLoan(loan.getName(),loan.getAadhar(),loan.getEmail(),loan.getAmount(),loan.getDuration(),loan.getPanCard(),loan.getLoanId());
	}
	
	public void updateProfile(User user) {
		userRepo.updateProfile(user.getName(),user.getMobilenumber(),user.getAadress(),user.getEmail(),user.getAadhar(),user.getPanCard(),user.getSalary(),user.getState(),user.getCountry(),user.getUserId());
	}

}
