package com.java.flight.tracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.flight.tracker.dao.FlightDAO;
import com.java.flight.tracker.entity.Flight;

@Controller
@RequestMapping("/flight")
public class FlightController {

	// inject DAO into Controller
	@Autowired
	private FlightDAO flightDAO;
	
	@RequestMapping("/list")
	public String getFlights(Model model) {
		// get flights from DAO
		List<Flight> flights = flightDAO.getFlights();
		// add flights to the model
		model.addAttribute("flights", flights);
		return "list-flights";
	}
}
