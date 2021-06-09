package com.ibm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.entity.EMIChart;
import com.ibm.entity.EMIChart2;
import com.ibm.service.EMIService;

@CrossOrigin()
@RestController
public class EMIController {
	
	@Autowired
	private EMIService service;

	
	@GetMapping(value = "/test/{a}/{b}", produces = "application/json")
	public EMIChart getTest(@PathVariable("a")int a,@PathVariable("b")int b) {
		return service.getTest(a,b);
	}
	@GetMapping(value = "/emi/{a}/{b}", produces = "application/json")
	public List<EMIChart2> getEmi(@PathVariable("a")double a,@PathVariable("b")double b) {
		return service.getEmi(a,b);
	}
	
}
