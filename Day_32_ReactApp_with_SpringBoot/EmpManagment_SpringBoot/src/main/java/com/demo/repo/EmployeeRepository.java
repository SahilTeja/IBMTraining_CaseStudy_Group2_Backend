package com.demo.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.demo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

	// there is not required to write query here bz findByename(String ename) done the work for us
	// findByename --> B should be capital & ename is field through which we want to execute our query
	Employee findByename(String ename);
	
	@Query("from Employee where hireDate <:joinDate")
	List<Employee> findAllJoinedBefore(@Param("joinDate") LocalDate joinDate);
	
	List<Employee> findAllByHireDateBetween(LocalDate start, LocalDate end);

}
