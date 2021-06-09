package com.loan.rest;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.loan.entity.Loan;
import com.loan.service.LoanService;


/**
 * 
 * @author abhay
 *
 */

@RestController
@CrossOrigin
public class LoanController {

	@Autowired
	LoanService service;

	@PostMapping(value = "/add", consumes = "application/json")
	public void addLoan(@RequestBody Loan loan) {
		service.addLoan(loan);
	}

	@GetMapping(path = "/list", produces = "application/json")
	public List<Loan> getAllList() {
		return service.getAll();
	}

	@GetMapping(path = "/get/{id}", produces = "application/json")
	public Loan getLoan(@PathVariable("id") int id) {
		return service.getById(id);
	}

	@PutMapping(path = "/approve/{id}", produces = "application/json")
	public boolean approveLoan(@RequestBody Loan loan, @PathVariable("id") int id) {
		return service.approveLoan(loan, id);
	}
	
	@PutMapping(path = "/reject/{id}", produces = "application/json")
	public boolean rejectLoan(@RequestBody Loan loan, @PathVariable("id") int id) {
		return service.rejectLoan(loan,id);
	}
	
	
	

	@DeleteMapping(path = "/del/{id}", produces = "application/json")
	public boolean delete(@PathVariable("id") int id) {
		return service.deleteLoan(id);
	}
	
	@GetMapping(path = "/check/{id}/{name}", produces = "application/json")
	public Loan checkStatus(@PathVariable("id") int id, @PathVariable String name) {
		return service.checkStatus(id,name);
	}
	
	@GetMapping(path = "/view/{id}", produces = "application/json")
	public Loan viewProfile(@PathVariable("id") int id) {
		return service.viewProfile(id);
	}
	

	@PutMapping(value="/edit")
	public boolean updateLoan(@RequestBody Loan loan) {
		return service.updateLoan(loan);

	}
	
	

}
