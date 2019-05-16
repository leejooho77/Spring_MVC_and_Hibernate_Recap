package com.java.flight.tracker.entity;


import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="flight")
public class Flight {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="flight_number")
	private String flightNumber;
	@OneToOne(cascade={
			CascadeType.DETACH,
			CascadeType.MERGE,
			CascadeType.REFRESH,
			CascadeType.PERSIST
	})
	@JoinColumn(name="departure_id")
	private Airport departure;
	@OneToOne(cascade={
			CascadeType.DETACH,
			CascadeType.MERGE,
			CascadeType.REFRESH,
			CascadeType.PERSIST
	})
	@JoinColumn(name="arrival_id")
	private Airport arrival;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
	@Column(name="departure_time")
	private LocalDateTime departureTime;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
	@Column(name="arrival_time")
	private LocalDateTime arrivalTime;
	
	public Flight() { }
	
	public Flight(String flightNumber, Airport departure, Airport arrival, LocalDateTime departureTime, LocalDateTime arrivalTime) {
		this.flightNumber = flightNumber;
		this.departure = departure;
		this.arrival = arrival;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getFlightNumber() {
		return flightNumber;
	}
	
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
	
	public Airport getDeparture() {
		return departure;
	}
	
	public void setDeparture(Airport departure) {
		this.departure = departure;
	}
	
	public Airport getArrival() {
		return arrival;
	}
	
	public void setArrival(Airport arrival) {
		this.arrival = arrival;
	}
	
	public LocalDateTime getDepartureTime() {
		return departureTime;
	}
	
	public void setDepartureTime(LocalDateTime departureTime) {
		this.departureTime = departureTime;
	}
	
	public LocalDateTime getArrivalTime() {
		return arrivalTime;
	}
	
	public void setArrivalTime(LocalDateTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	@Override
	public String toString() {
		return "Flight [id=" + id + ", flightNumber=" + flightNumber + ", departure=" + departure + ", arrival="
				+ arrival + ", departureTime=" + departureTime + ", arrivalTime=" + arrivalTime + "]";
	}

}
