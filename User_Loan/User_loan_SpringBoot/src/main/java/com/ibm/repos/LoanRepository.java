package com.ibm.repos;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ibm.entity.Loan;
/**
 * 
 * @author Harsh Anand
 *
 */
public interface LoanRepository extends JpaRepository<Loan, Integer> {

	@Query("FROM Loan b where b.user.userId=(?1)")
	List<Loan> findByUserId(@Param("userId") int userId);
	
	@Query("FROM Loan b where b.name=(?1)")
	List<Loan> findLoanByName(@Param("name") String name);

	@Query("FROM Loan b where b.emiCompleted=('No') and b.status=('Pending')")
	List<Loan> findAllLoan();
	
	@Transactional
	@Modifying
	@Query("update Loan b set b.status = ('Approved') where b.loanId = (?1) ")
	 void approveLoan(@Param("loanId") int loanId);
	
	@Transactional
	@Modifying
	@Query("update Loan b set b.status = ('Rejected') where b.loanId = (?1) ")
	void rejectLoan(@Param("loanId") int loanId);
	
	@Transactional
	@Modifying
	@Query("update Loan b set b.emiCompleted = ('Yes') where b.loanId = (?1) ")
	void EMIpayment(@Param("loanId") int loanId);

}
