package com.loan.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loan.entity.Loan;
import com.loan.repository.LoanRepository;


/**
 * 
 * @author abhay
 *
 */

@Service
public class LoanService {
	
	@Autowired
	LoanRepository repo;

	public void addLoan(Loan loan) {
		repo.save(loan);
	}

	public List<Loan> getAll() {
		return repo.findAll();
		
	}

	public boolean approveLoan(Loan loan,int id) {
		if(getById(id)!=null) {
			loan.setStatus("Approved");
			return repo.save(loan)!=null ? true: false;
		}
		return false;
	}

	public boolean rejectLoan(Loan loan,int id) {
		if(getById(id)!=null) {
			loan.setStatus("Rejected");
			return repo.save(loan)!=null ? true: false;
		}
		return false;
	}

	
	
	public Loan getById(int id) {
		Optional<Loan> optional = repo.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}else {
			return null;
		}
//		return repo.findById(id).get();
	}

	public boolean deleteLoan(int id) {
		if(getById(id)!=null) {
			Loan loan = getById(id);
			repo.delete(loan);
			return true;
		}
		return false;
	}

	public Loan checkStatus(int id, String name) {
		Loan l = getById(id);
		if(l!=null && l.getName().equalsIgnoreCase(name)) {
			return l;
		}
		return null;
	}

	public Loan viewProfile(int id) {
		Loan l = getById(id);
		if(l!=null) {
			return l;
		}
		else {
			return null;
		}
	}

	public boolean updateLoan(Loan loan) {
		if(getById(loan.getlId())!=null) {
			return repo.save(loan) !=null?true : false;
		}
		return false;
	}

	

}
