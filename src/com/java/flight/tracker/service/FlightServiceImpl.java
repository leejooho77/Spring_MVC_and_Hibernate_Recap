package com.java.flight.tracker.service;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

	@Override
	@Transactional
	public List<Flight> getFlights() {
		return flightDAO.getFlights();
	}

}
