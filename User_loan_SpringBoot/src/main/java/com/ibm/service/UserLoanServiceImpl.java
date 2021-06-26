package com.ibm.service;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;


import com.ibm.entity.User;
import com.ibm.entity.Admin;
import com.ibm.entity.Cibil;
import com.ibm.entity.EMIChart;
import com.ibm.entity.Loan;
import com.ibm.repos.UserRepository;
import com.ibm.repos.AdminRepository;
import com.ibm.repos.CibilRepository;
import com.ibm.repos.LoanRepository;

@Service
public class UserLoanServiceImpl implements UserLoanService {
	
	@Autowired
	private LoanRepository loanRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private AdminRepository adminRepo;
	
	@Autowired
	private CibilRepository cibilRepo;
	
	@Autowired
	private JavaMailSender mailSender;
	
	/*	Interest Rate is calculated based on Cibil Score  */
	public void interestCalculation(Loan loan) {
		int Cibil = findCibilbyId(loan.getPanCard());
		
		if (Cibil >= 550 && Cibil < 700) {
			loan.setInterest(13);
		}
		else if (Cibil >= 700 && Cibil < 750) {
			loan.setInterest(10);
		}
		else if (Cibil >= 750 && Cibil < 900) {
			loan.setInterest(7);
		}
		else {
			loan.setStatus("Rejected");
			loan.setComment("Too Low Cibil");
			loan.setInterest(0);
			AutorejectLoanMail(loan.getComment(),loan.getEmail(),loan.getName());
		}
	}
	
	/*	Loan Status is decided based on Loan Amount & Cibil Score (for reject--> Loan Amount>7000000 & CibilScore < 550)  */
	public double loanApprovalAmount(Loan loan) {
		int cibil = findCibilbyId(loan.getPanCard());
		if(cibil>550 && loan.getAmount()<=7000000) {
			if (loan.getSalary() < 30000) {
				loan.setComment("Only 40% of Amount Applied");
				return (int) (loan.getAmount() * 0.4);
			}
			else if (loan.getSalary() >= 30000 && loan.getSalary() < 60000) {
				loan.setComment("Only 55% of Amount Applied");
				return (int) (loan.getAmount() * 0.55);
			}
			else if (loan.getSalary() >= 60000 && loan.getSalary() < 100000) {
				loan.setComment("Only 70% of Amount Applied");
				return (int) (loan.getAmount() * 0.7);
			}
			else if (loan.getSalary() >= 100000 && loan.getSalary() < 150000) {
				loan.setComment("Only 80% of Amount Applied");
				return (int) (loan.getAmount() * 0.8);
			}
			else if (loan.getSalary() >= 150000 && loan.getSalary() < 200000) {
				loan.setComment("Only 90% of Amount Applied");
				return (int) (loan.getAmount() * 0.9);
			}
			else {
				loan.setComment("100% of Amount Applied");
				return (int) (loan.getAmount() * 1);
			}
		}
		else {
			if(loan.getAmount()>7000000) {
				loan.setComment("Loan Amount > 70Lakh");
				loan.setStatus("Rejected");
				System.out.println("Rejected------>"+loan.getComment()+"------"+loan.getLoanId());
				AutorejectLoanMail(loan.getComment(),loan.getEmail(),loan.getName());
				return loan.getAmount();
			}
			else {
				loan.setComment("Cibil Score < 550");
				loan.setStatus("Rejected");
				AutorejectLoanMail(loan.getComment(),loan.getEmail(),loan.getName());
				return loan.getAmount();
			}			
		}		
	}
	
	/*	Auto Rejection Mail for Loan Reject due to LoanAmount > 70Lakh or CibilScore < 550  */
	private void AutorejectLoanMail(String comment, String email, String name) {	
		String to = email;
		String subject = "Loan Auto Rejected";
		String body = "Sorry, " + name + " Your Home Loan is Rejected."+"\n Due to : "+ comment 
				+ "\nDO NOT share this mail with anyone.";
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(to);
		message.setSubject(subject);
		message.setText(body);
		mailSender.send(message);
		
	}
		
	//	Register Admin  
	public boolean addAdmin(Admin admin) {
		return adminRepo.save(admin)!=null?true:false;
	}
	
	/*	Find All Admin  */
	public List<Admin> findAllAdmin(){
		return adminRepo.findAll();
	}
	
	/*	Adding CibilScore in DB and primaryKey is Pan_Card  */
	public boolean addCibilScore(Cibil cibil) {
		return cibilRepo.save(cibil)!=null?true:false;
	}
	
	/*	Finding CibilScore by ID(Pan_card)  */
	public int findCibilbyId(String panCard){
		List<Cibil> allpancard = findAllCibil();
		for(Cibil pan:allpancard) {
			if(pan.getPanCard().equals(panCard)) {
				
				return pan.getCibilscore();
			}
		}
		return 0;
	}
	
	/*	Find all CibilScore along with Pan_card  */
	public List<Cibil> findAllCibil(){
		return cibilRepo.findAll();
	}
	
	/*	User Registration Mail Notification  */
	public void sendMailUser(User user) {
		String to = user.getEmail();
		String subject = "User Registered Successfully";
		String body ="Congratulations, " + user.getName() +" You have successfully registered on our Website."
				+ "\nDO NOT share your password with anyone.";
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(to);
		message.setSubject(subject);
		message.setText(body);
		mailSender.send(message);

	}
	
	/*	User Registration  */
	public int saveUser(User user) {
		userRepo.save(user);
		sendMailUser(user);
		return user.getUserId();
	}
	
	/*	Email Notification for Loan Applied  */
	public void sendMailLoan(Loan loan) {
		if(loan.getStatus()!="Rejected") {
			int loanId = loan.getLoanId();
			String Name = loan.getName();
			double amount = loan.getAmount();
			String to = loan.getEmail();
			String subject = "Loan Applied Successfully";
			String body = "Welcome " + Name + "\nYou have successfully applied for the loan. Your loan id is " + loanId
					+ " and your Approved loan amount is " + amount + " with interest rate "+ loan.getInterest() + "." 
					+ "\nInterest rate is decided based on your CIBIL Score. Your CIBIL Score is :"+ findCibilbyId(loan.getPanCard()) + "."
					+ "\nDO NOT share and forward this email with anyone."
					+ "\nThank you!";
			SimpleMailMessage message = new SimpleMailMessage();
			message.setTo(to);
			message.setSubject(subject);
			message.setText(body);
			mailSender.send(message);
		}

	}
	
	/*	Apply loan  */
	public int saveLoan(Loan loan,int userId) {
		List<Loan> list = getallLoanbyuserId(userId);
		String emiCompleted = "Yes";
		String status = "Pending";
		for(Loan loan1:list) {
			 emiCompleted = loan1.getEmiCompleted();
			 status = loan1.getStatus();		 
		}
//		System.out.println("======="+emiCompleted+"========="+status);

		if((emiCompleted.equals("Yes")) || status.equals("Rejected")) {
			User user = getUserbyID(userId);
			loan.setUser(user);
			
			interestCalculation(loan);
			double ApprovedAmount = loanApprovalAmount(loan);
			loan.setAmount(ApprovedAmount);
				
			loanRepo.save(loan);
			sendMailLoan(loan);
			return loan.getLoanId();
		}
		
		else {
			return 0;
		}	
			
	}
	
	/*	Fetch Loan details by loanId  */
	public Loan getLoanbyID(int loanId) {
		return loanRepo.findById(loanId).get();
	}
	
	/*	Fetch User Details by userId  */
	public User getUserbyID(int userId) {
		return userRepo.findById(userId).get();
	}
	
	/*	Fetch all Loan for Specific User (by UserID)  */
	public List<Loan> getallLoanbyuserId(int userId) {
		return loanRepo.findByUserId(userId);
	}
	
	/*	Fetch loan details by loanId  */
	public List<Loan> getallLoanbyloanId(int loanId) {
		return loanRepo.findByLoanId(loanId);
	}
	
	/*	Fetch loan details by ApplicantName  */
	public List<Loan> getallLoanbyName(String name) {
		return loanRepo.findLoanByName(name);
	}
	
	/*	Fetch all Registered User  */
	public List<User> findAllUser() {
		return userRepo.findAll();
	}
	
	/*	Fetch loan details whose EMI not completed & status is pending */
	public List<Loan> findLoanbyPendingApproval() {   
		return loanRepo.findLoanbyPendingApproval();
	}
	
	/*	Fetch all Loan applied till yet  */
	public List<Loan> findallloan() {   
		return loanRepo.findAll();
	}
	
	/*	Email Notification for Loan Approved by Admin  */
	private void approveLoanMail(String comment, int id) {
		Loan loan = getLoanbyID(id);
		String to = loan.getEmail();
		String subject = "Loan Status Changed";
		String body = "Congratulations, " + loan.getName() +" Your Home Loan is Accepted"
				+ "\nDO NOT share this mail with anyone.";
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(to);
		message.setSubject(subject);
		message.setText(body);
		mailSender.send(message);
		
	}
	
	/*	Update Loan Status to Approved and adding Comment to it by its LoanID  */
	public void approveLoan(int id, String comment) {
		 loanRepo.approveLoan(comment,id);
		 approveLoanMail(comment,id);
	}

	/*	Email Notification for Loan Rejected by Admin  */
	private void rejectLoanMail(String comment, int id) {
		Loan loan = getLoanbyID(id);
		String to = loan.getEmail();
		String subject = "Loan Status Changed";
		String body = "Sorry, " + loan.getName() + " Your Home Loan is Rejected."+"\n Due to : "+ comment 
				+ "\nDO NOT share this mail with anyone.";
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(to);
		message.setSubject(subject);
		message.setText(body);
		mailSender.send(message);
		
	}
	
	/*	Update Loan Status to Rejected and updating Comment to it by its LoanID  */
	public void rejectLoan(int id, String comment) {
		loanRepo.rejectLoan(comment,id);
		rejectLoanMail(comment,id);
	}
	
	/*	Update forClosure payment / EMI Completed after complete Payment of Loan by its LoanID  */
	public void EMIpayment(int id) {
		loanRepo.EMIpayment(id);
	}
	
	/*	Edit Loan Application after Loan Applied  */
	public void editLoan(Loan loan) {
		double previousApprovedAmount = getLoanbyID(loan.getLoanId()).getAmount();
		double ApprovedAmount;
		
		if((previousApprovedAmount < loan.getAmount()) || loan.getAmount()>=7000000) {
			ApprovedAmount = loanApprovalAmount(loan);
		}
		else {
			ApprovedAmount = loan.getAmount();
			loan.setComment("100% bz Amnt<=previous Amnt");
		}
		
		loan.setAmount(ApprovedAmount);
		loanRepo.editLoan(loan.getAmount(),loan.getDuration(),loan.getComment(), loan.getStatus(),loan.getLoanId());
	}
	
	
	/*	Profile updation of User before applying Loan  */
	public void updateProfile(User user) {
		userRepo.updateProfile(user.getName(),user.getMobilenumber(),user.getAadress(),user.getEmail(),user.getAadhar(),user.getPanCard().toUpperCase(),user.getSalary(),user.getState(),user.getCountry(),user.getDateofbirth(),user.getUserId());
	}
	
	/*	Email notification for OTP for payment of ForClosure Payment/EMI Completition */
	public void sendOtpMail(int otp,int loanId) {
		int OTP = otp;
		Loan loan = getLoanbyID(loanId);
		String to = loan.getEmail();
		String subject = "Foreclosure Payment OTP";
		String body = "Your One Time Password for Foreclosure Payment is "+ OTP
				+ "\nDO NOT share your OTP with anyone.";
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(to);
		message.setSubject(subject);
		message.setText(body);
		mailSender.send(message);	
	}
	
	/*	Email Notification for Completition of EMI / complete payment for ForClosure Payment  */
	public void LoanCompletition(int loanId) {
		Loan loan = getLoanbyID(loanId);
		String to = loan.getEmail();
		String subject = "Home Loan EMI Completed";
		String body = "Congratulations, " + loan.getName() +" Your Home Loan EMI is Completed. "
				+ "\n Now, You can apply new loan also."
				+ "\nDO NOT share this mail with anyone.";
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(to);
		message.setSubject(subject);
		message.setText(body);
		mailSender.send(message);
		
	}
	
	/*	Email Notification for forget password along with its password  */
	public void forgetPassword(int userid, String passwd) {
		User user = getUserbyID(userid);
		String userName = user.getName();
		String to = user.getEmail();
		String subject = "Recover Password";
		String body = "Hello, " +userName +" Your Password is --- " + passwd
				+ "\nDO NOT share your password with anyone.";
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(to);
		message.setSubject(subject);
		message.setText(body);
		mailSender.send(message);

	}
	
	//---------------------------EMICHART-------------------------------------------
	
	/*	EMI Chart generation for approved principal, time, interest  */
	public List<EMIChart> getEmichart(double principal, double time, double interest) {
		List<EMIChart> charttest = new ArrayList<EMIChart>();
		EMIChart(charttest,principal,time,interest);
		System.out.println("++++++++==================="+charttest);
		return charttest;
	}
	
	//method to support calculation for getEmiChart()
	int calculateEMI(double principal,double time,double interest) {
		double rate = interest/100;
		double emi = principal*rate*Math.pow((1+rate), time)/(Math.pow((1+rate), time)-1);
//		System.out.println("EMI is :"+(int)Math.ceil(emi) +"--"+ principal +"--"+ time +"--"+ rate);
		return (int)Math.ceil(emi);
	}
	
	//method to support calculation for getEmiChart()
	public List<EMIChart> EMIChart(List<EMIChart> charttest,double principal,double time,double interest) {
		
		double openingBal = principal;
		double closingBal;
		double interestPaidYearly;
		double principlePaidYearly;
		double FinalEMI = 0;
		FinalEMI = calculateEMI(principal,time,interest);
		System.out.println(String.format("| %-4s | %-10s | %-8s | %-18s | %-19s | %-10s |","Year","OpeningBal","EMI","InterestPaidYearly","PrinciplePaidYearly","ClosingBal"));
		System.out.println(String.format("|%-6s|%-12s|%-10s|%-20s|%-21s|%-11s|","------","------------","----------","--------------------","---------------------","------------"));

		for(int i=1; i<=time; i++) {
			EMIChart temp = new EMIChart();
			interestPaidYearly = (int) (openingBal *(interest/100.0));
			principlePaidYearly = FinalEMI-interestPaidYearly;
			closingBal = openingBal - principlePaidYearly;
			if(i==time) {
				FinalEMI = openingBal;
				interestPaidYearly = (int) (openingBal *(interest/100.0));
				principlePaidYearly = FinalEMI-interestPaidYearly;
				closingBal=0;
			}
			System.out.println(String.format("|  %-4s|  %-10s|  %-8s|  %-18s|  %-19s|  %-10s|",i,openingBal,FinalEMI,interestPaidYearly,principlePaidYearly,closingBal));
			temp.setOpeningBal(openingBal);
			openingBal=closingBal;
			temp.setYear(i);
			temp.setEmi(FinalEMI);
			temp.setInterestPaidYearly(interestPaidYearly);
			temp.setPrinciplePaidYearly(principlePaidYearly);
			temp.setClosingbal(closingBal);
			charttest.add(temp);
		}
		return charttest;
	}

}
