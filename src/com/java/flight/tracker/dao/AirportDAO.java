package com.java.flight.tracker.dao;

import java.util.List;

import com.java.flight.tracker.entity.Airport;

public interface AirportDAO {

	public List<Airport> getAirports();
	public List<Integer> getIdByCountry(String name);
	
}
