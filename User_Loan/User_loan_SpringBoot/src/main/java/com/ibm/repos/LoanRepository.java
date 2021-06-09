package com.ibm.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
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

	@Query("FROM Loan b where b.emiCompleted=('No')")
	List<Loan> findAllLoan();

}
