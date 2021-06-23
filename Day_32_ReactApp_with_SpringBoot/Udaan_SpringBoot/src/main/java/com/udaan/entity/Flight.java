package com.udaan.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**  (inserted by /** & enter)
 * Represent a flight in database table "flight_master"
 * @author Harsh Anand
 * @version 1.0
 */

@Entity
@Table(name="flights_master")
public class Flight {
	@Id
	private int code;
	@Column(length = 20)
	private String carrier;
	@Column(length = 20)
	private String source;
	@Column(length = 20)
	private String destination;
	private double duration;
	private double price;
	
	// Getters & Setters
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getCarrier() {
		return carrier;
	}
	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public double getDuration() {
		return duration;
	}
	public void setDuration(double duration) {
		this.duration = duration;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	

}
