package com.java.flight.tracker.service;

import java.util.List;

import com.java.flight.tracker.entity.Airport;

public interface AirportService {

	public List<Airport> getAirports();
	public List<Integer> getIdByCountry(String name);
	
}
