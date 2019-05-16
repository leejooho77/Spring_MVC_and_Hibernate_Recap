package com.java.flight.tracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java.flight.tracker.dao.FlightDAO;
import com.java.flight.tracker.entity.Flight;

@Service
public class FlightServiceImpl implements FlightService {

	@Autowired
	private FlightDAO flightDAO;
	@Autowired
	private AirportService airportService;

	@Override
	@Transactional
	public List<Flight> getFlights() {
		return flightDAO.getFlights();
	}
	
	@Override
	@Transactional
	public List<Flight> searchFlightByDeparture(String departureName) {
		List<Integer> airportIds = airportService.getIdByCountry(departureName);
		return flightDAO.searchFlightByDeparture(airportIds);
	}
	
	@Override
	@Transactional
	public Flight getFlight(int id) {
		return flightDAO.getFlight(id);
	}

	@Override
	@Transactional
	public void saveFlight(Flight flight) {
		flightDAO.saveFlight(flight);
	}
	
	@Override
	@Transactional
	public void deleteFlight(int id) {
		flightDAO.deleteFlight(id);
	}

}
