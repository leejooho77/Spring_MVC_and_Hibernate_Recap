package com.java.flight.tracker.dao;

import java.util.List;

import com.java.flight.tracker.entity.Flight;

public interface FlightDAO {
	
	public List<Flight> getFlights();
}
