package com.demo.service;

import java.time.LocalDate;
import java.util.List;

import com.demo.entity.Employee;

public interface EmployeeService {
	

	boolean addEmp(Employee emp);
	
	Employee findEmpbyID(int empno);
	Employee findEmpbyname(String empname);
	
	List<Employee> findAllEmp();
	
	boolean updateEmp(Employee emp);
	
	boolean deleteEmp(int empno);

	List<Employee> getAllJoinedUntil(LocalDate joinUntil);
	
	List<Employee> getAllJoinedBetwen(LocalDate start, LocalDate end);

}
