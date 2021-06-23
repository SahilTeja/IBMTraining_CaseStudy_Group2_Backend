package com.udaan.service;

import java.util.List;

import com.udaan.entity.Flight;

/**
 * Service interface for Flight
 * @author Harsh
 * @version 1.0
 *
 */

public interface FlightService {
	
	void addFlight(Flight flight);
	
	Flight getByCode(int code);
	
	List<Flight> getAllFlights();
	
	List<Flight> getByCarrier(String carrier);
	
	List<Flight> getByRoute(String source, String destination);
	
	void removeFlight(int code);

	boolean updateFlight(Flight flight);

}
