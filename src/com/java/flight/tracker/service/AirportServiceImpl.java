package com.java.flight.tracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java.flight.tracker.dao.AirportDAO;
import com.java.flight.tracker.entity.Airport;

@Service
public class AirportServiceImpl implements AirportService {

	@Autowired
	AirportDAO airportDAO;
	
	@Override
	@Transactional
	public List<Airport> getAirports() {
		return airportDAO.getAirports();
	}
	
	@Override
	@Transactional
	public List<Integer> getIdByCountry(String name) {
		return airportDAO.getIdByCountry(name);
	}

}
