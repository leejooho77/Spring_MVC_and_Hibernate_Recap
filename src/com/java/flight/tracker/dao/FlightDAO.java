package com.java.flight.tracker.dao;

import java.util.List;

import com.java.flight.tracker.entity.Flight;

public interface FlightDAO {
	
	public List<Flight> getFlights();
	public List<Flight> searchFlightByDeparture(List<Integer> airportIds);
	public Flight getFlight(int id);
	public void saveFlight(Flight flight);
	public void deleteFlight(int id);
}
