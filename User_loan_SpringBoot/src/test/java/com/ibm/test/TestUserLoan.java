package com.ibm.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.ibm.entity.Admin;
import com.ibm.entity.Cibil;
import com.ibm.entity.Loan;
import com.ibm.entity.User;
import com.ibm.repos.AdminRepository;
import com.ibm.repos.CibilRepository;
import com.ibm.repos.LoanRepository;
import com.ibm.repos.UserRepository;
import com.ibm.service.UserLoanService;
@SpringBootTest
public class TestUserLoan {
	
	@MockBean
	private UserRepository userRepo;
	
	@MockBean
	private CibilRepository cibilRepo;
	
	@MockBean
	private LoanRepository loanRepo;
	
	@MockBean
	private AdminRepository adminRepo;
	
	@Autowired
	private UserLoanService service;
	
	@Test
	public void testUser() throws Exception {
		User user = new User("sahil","abhaypandey55010@gmail.com","abhay");
		when(userRepo.save(user)).thenReturn(user);
		assertNotNull(user.getUserId());
	}
	
	@Test
	public void testAllUser() throws Exception {
		when(userRepo.findAll()).thenReturn(Stream.of(new User("sahil","abhaypandey55010@gmail.com","abhay")).collect(Collectors.toList()));
		assertEquals(1, service.findAllUser().size());
		
	}
	
	@Test
	public void testAdmin() throws Exception {
		Admin admin = new Admin("abhaypandey55010@gmail.com","abhay");
		when(adminRepo.save(admin)).thenReturn(admin);
		assertEquals(true, service.addAdmin(admin));
	}

	@Test
	public void testAllAdmin() throws Exception {
		when(adminRepo.findAll()).thenReturn(Stream.of(new Admin("abhaypandey55010@gmail.com","abhay")).collect(Collectors.toList()));
		assertEquals(1, service.findAllAdmin().size());
		
	}

	@Test
	public void testLoan() throws Exception {
		Loan loan = new Loan("sahil","657657576","ABC123",50000,1000000,5);
		when(loanRepo.save(loan)).thenReturn(loan);
		assertNotNull(loan.getLoanId());
	}
	

	@Test
	public void testFindAllLoan() throws Exception {
		when(loanRepo.findAll()).thenReturn(Stream.of(new Loan("sahil","6476476476","ABC123",50000,1000000,5)).collect(Collectors.toList()));
		assertEquals(1, service.findallloan().size());
	}

	@Test
	public void testApproveLoan() throws Exception {
		doNothing().when(loanRepo).approveLoan(anyString(), anyInt());
		loanRepo.approveLoan("accepted", 70);
		verify(loanRepo,times(1)).approveLoan("accepted", 70);
	}
	
	@Test
	public void testRejectLoan() throws Exception {
		doNothing().when(loanRepo).rejectLoan(anyString(), anyInt());
		loanRepo.rejectLoan("Rejected", 70);
		verify(loanRepo,times(1)).rejectLoan("Rejected", 70);
	}
	
	@Test
	public void testCibil() throws Exception {
		Cibil cibil = new Cibil("ABC123",680);
		when(cibilRepo.save(cibil)).thenReturn(cibil);
		assertEquals(true, service.addCibilScore(cibil));
	}
	
	@Test
	public void testAllCibil() throws Exception {
		when(cibilRepo.findAll()).thenReturn(Stream.of(new Cibil("ABC123",680),new Cibil("ABC124",700)).collect(Collectors.toList()));
		assertEquals(2, service.findAllCibil().size());
	}

	@Test
	public void testGetLoanBYName() throws Exception {
		when(loanRepo.findLoanByName("sahil")).thenReturn(Stream.of(new Loan("sahil","6476476476","ABC123",50000,1000000,5)).collect(Collectors.toList()));
		assertEquals(1, service.getallLoanbyName("sahil").size());
	}

	
	
	
	
	

}