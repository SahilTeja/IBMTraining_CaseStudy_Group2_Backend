package com.ibm.repos;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ibm.entity.Loan;

public interface LoanRepository extends JpaRepository<Loan, Integer> {

	@Query("FROM Loan b where b.user.userId=(?1)")
	List<Loan> findByUserId(@Param("userId") int userId);
	
	@Query("FROM Loan b where b.loanId=(?1)")
	List<Loan> findByLoanId(@Param("loanId") int loanId);
	
	@Query("FROM Loan b where b.name=(?1)")
	List<Loan> findLoanByName(@Param("name") String name);

	@Query("FROM Loan b where b.emiCompleted=('No') and b.status=('Pending')")
	List<Loan> findLoanbyPendingApproval();
	
	
	@Transactional
	@Modifying
	@Query("update Loan b set b.status = ('Approved'), b.comment=(?1) where b.loanId = (?2) ")
	void approveLoan(@Param("comment") String comment,@Param("loanId") int loanId);
	
	@Transactional
	@Modifying
	@Query("update Loan b set b.status = ('Rejected'), b.comment=(?1) where b.loanId = (?2) ")
	void rejectLoan(@Param("comment") String comment, @Param("loanId") int loanId);
	
	@Transactional
	@Modifying
	@Query("update Loan b set b.emiCompleted = ('Yes') where b.loanId = (?1) ")
	void EMIpayment(@Param("loanId") int loanId);
	
	@Transactional
	@Modifying
	@Query("update Loan b set b.amount =(?1),b.duration = (?2),b.comment = (?3),b.status = (?4) where b.loanId = (?5)")
	void editLoan(@Param("amount")double amount, @Param("duration")double duration, @Param("comment")String comment, @Param("status")String status, @Param("loanId") int loanId);

	
}
