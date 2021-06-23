package com.udaan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udaan.entity.Flight;
import com.udaan.repo.FlightRepository;

/**
 * Service Implementation for Flight
 * @author Harsh
 * @version 1.0
 *
 */

@Service
public class FlightServiceImpl implements FlightService {

	@Autowired
	private FlightRepository repo;
	
	@Override
	public void addFlight(Flight flight) {
		repo.save(flight);

	}

	@Override
	public Flight getByCode(int code) {
		return repo.findById(code).get();
	}

	@Override
	public List<Flight> getAllFlights() {
		return repo.findAll();
	}

	@Override
	public List<Flight> getByCarrier(String carrier) {
		return repo.findByCarrier(carrier);
	}

	@Override
	public List<Flight> getByRoute(String source, String destination) {
		return repo.findByRoute(source, destination);
	}

	@Override
	public void removeFlight(int code) {
		repo.deleteById(code);
	}
	
	@Override
	public boolean updateFlight(Flight flight) {
		if(getByCode(flight.getCode())!=null) {
			return repo.save(flight)!=null?true:false;
		}else {
			return false;
		}
	}

}
