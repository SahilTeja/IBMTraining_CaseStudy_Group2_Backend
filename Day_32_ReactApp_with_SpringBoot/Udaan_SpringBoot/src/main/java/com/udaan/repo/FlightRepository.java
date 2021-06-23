package com.udaan.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.udaan.entity.Flight;

/**
 * Main Repository for flight entity, with custom queries
 * @author Harsh
 *@version 1.0
 */
public interface FlightRepository extends JpaRepository<Flight, Integer> {
	
	
	// there is not required to write query here bz findByCarrier(String carrier) done the work for us
	// findByCarrier --> B should be capital & Carrier/carrier is field through which we want to execute our query
	List<Flight> findByCarrier(String carrier);
	
	//List<Flight> findBySourceandDestination(String source, String destination);
    @Query("FROM Flight WHERE source=:src AND destination=:dest")
    List<Flight> findByRoute(@Param("src")String source, @Param("dest")String destination);

}
