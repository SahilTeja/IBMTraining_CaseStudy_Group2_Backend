package com.demo.rest;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entity.Employee;
import com.demo.service.EmployeeService;

@CrossOrigin
@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;
	
	
	@PostMapping(path = "save",consumes = "application/json")
	public boolean saveEmp(@RequestBody Employee emp) {
		return empService.addEmp(emp);
	}
	
	@GetMapping(path = "findbyid/{empno}", produces = "application/json")
	public Employee findEmployeebyID(@PathVariable("empno") int empno) {
		return empService.findEmpbyID(empno);
	}
	@GetMapping(path = "findbyname/{empname}", produces = "application/json")
	public Employee findEmployeebyname(@PathVariable("empname") String empname) {
		return empService.findEmpbyname(empname);
	}
	
	@GetMapping(path = "find", produces = "application/json")
	public List<Employee> findAllEmployee(){
		return empService.findAllEmp();
	}
	
	@PutMapping(path = "update", produces = "application/json")
	public boolean updateEmployee(@RequestBody Employee emp) {
		return empService.updateEmp(emp);
	}
	
	@DeleteMapping(path = "delete/{empno}", produces = "application/json")
	public boolean deleteEmployee(@PathVariable("empno") int empno) {
		return empService.deleteEmp(empno);
	}
	
	@GetMapping(value = "/find/{until}", produces = "application/json")
	public List<Employee> joinedUntil(@PathVariable("until") LocalDate joinUntil) {
		return empService.getAllJoinedUntil(joinUntil);
	}
	
	@GetMapping(value = "/between/{start}/{end}", produces = "application/json")
	public List<Employee> joinedBetween(@PathVariable LocalDate start, @PathVariable LocalDate end) {
		return empService.getAllJoinedBetwen(start, end);
	}

}
