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
		List<Flight> flights = flightDAO.getFlights();
//		formatDateTime(flights);
		return flights;
	}

	public void formatDateTime(List<Flight> flights) {
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		for (Flight flight : flights) {
			String unformattedDepartureTime = flight.getDepartureTime().toString();
			String unformattedArrivalTime = flight.getArrivalTime().toString();
			flight.setDepartureTime(LocalDateTime.parse(unformattedDepartureTime, format));
			flight.setArrivalTime(LocalDateTime.parse(unformattedArrivalTime, format));
		}
	}

}
