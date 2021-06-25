package com.ibm.service;

import java.util.List;

import com.ibm.entity.User;
import com.ibm.entity.Admin;
import com.ibm.entity.Cibil;
import com.ibm.entity.EMIChart;
import com.ibm.entity.Loan;


public interface UserLoanService {
		
	boolean addAdmin(Admin admin);
	
	List<Admin> findAllAdmin(); 
	
	boolean addCibilScore(Cibil cibil);
	
	List<Cibil> findAllCibil();
	
	int saveUser(User user);
	
	List<User> findAllUser();
	
	int saveLoan(Loan loan,int userId);
	
	Loan getLoanbyID(int loanId);
	
	User getUserbyID(int userId);
	
	List<Loan> getallLoanbyuserId(int userId);
	
	List<Loan> getallLoanbyloanId(int loanId);
	
	List<Loan> getallLoanbyName(String name);
	
	List<Loan> findLoanbyPendingApproval();   //whose Emi not completed & status is pending
		
	List<Loan> findallloan();
	
	void approveLoan(int id, String comment);
	
	void rejectLoan(int id, String comment);
	
	void EMIpayment(int id);
	
	void editLoan(Loan loan);
	
	void updateProfile(User user);
	
	void sendOtpMail(int otp,int loanId);
	
	void forgetPassword(int userid, String passwd);
	
	void LoanCompletition(int loanId);
	
	List<EMIChart> getEmichart(double principal, double time, double interest);
	
	
}
