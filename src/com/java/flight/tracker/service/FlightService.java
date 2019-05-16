package com.java.flight.tracker.service;

import java.util.List;

import com.java.flight.tracker.entity.Flight;

public interface FlightService {

	public List<Flight> getFlights();
	public List<Flight> searchFlightByDeparture(String departureName);
	public Flight getFlight(int id);
	public void saveFlight(Flight flight);
	public void deleteFlight(int id);
}
