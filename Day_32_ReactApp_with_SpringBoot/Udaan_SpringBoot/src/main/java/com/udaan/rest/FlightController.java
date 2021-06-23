package com.udaan.rest;

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

import com.udaan.entity.Flight;
import com.udaan.service.FlightService;

@RestController
@CrossOrigin()
public class FlightController {
	
	@Autowired
	private FlightService service;
	
	//http://localhost:8880/add
	//consumes--> it convert the json into object to pass as parameter
	@PostMapping(path = "/add", consumes = "application/json")
	public void addFlight(@RequestBody Flight flight) {
		service.addFlight(flight);
	}
	
	//http://localhost:8880/flight/1234
	//produce--> it convert the object returned from function into json bz Object is understand by this java project only
	@GetMapping(path = "/flight/{code}", produces = "application/json")
	public Flight getFlight(@PathVariable("code") int code) {
		return service.getByCode(code);
	}
	
	//http://localhost:8880/flights
	@GetMapping(path = "/flights", produces = "application/json")
	public List<Flight> getAllFlight() {
		return service.getAllFlights();
	}
	
	//http://localhost:8880/flights/Indigo
	@GetMapping(path = "/flights/{carrier}", produces = "application/json")
	public List<Flight> getbyCarrier(@PathVariable("carrier") String carrier) {
		return service.getByCarrier(carrier);
	}
	
	//http://localhost:8880/flights/Mumbai/Goa
	@GetMapping(path = "/flights/{source}/{destination}", produces = "application/json")
	public List<Flight> getbyRoute(@PathVariable("source") String source, @PathVariable("destination") String destination) {
		return service.getByRoute(source, destination);
	}
	
	//http://localhost:8880/del/1234
	@DeleteMapping(value = "/del/{code}")
	public void deleteFlight(@PathVariable int code) {
		service.removeFlight(code);
	}
	
	//http://localhost:8880/update
	@PutMapping(path = "/update/", produces = "application/json")
	public boolean updateEmployee(@RequestBody Flight flight) {
		return service.updateFlight(flight);
	}
	
	
	
	

}
