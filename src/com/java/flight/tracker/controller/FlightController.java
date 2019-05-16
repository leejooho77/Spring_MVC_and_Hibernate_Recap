package com.java.flight.tracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.java.flight.tracker.entity.Airport;
import com.java.flight.tracker.entity.Flight;
import com.java.flight.tracker.service.AirportService;
import com.java.flight.tracker.service.FlightService;

@Controller
@RequestMapping("/flight")
public class FlightController {

	// inject DAO into Controller
	@Autowired
	private FlightService flightService;
	@Autowired
	private AirportService airportService;
	
	@GetMapping("/list")
	public String getFlights(Model model) {
		// get flights from DAO
		List<Flight> flights = flightService.getFlights();
		// add flights to the model
		model.addAttribute("flights", flights);
		return "list-flights";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		// create model attribute to bind form data
		Flight flight = new Flight();
		// add to attribute
		model.addAttribute("flight", flight);
		return "flight-form";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("flightId") int id, Model model) {
		// get the flight from the database
		Flight flight = flightService.getFlight(id);
		// set flight as a model attribute to pre-populate form
		model.addAttribute("flight", flight);
		return "flight-form";
	}
	
	@PostMapping("/saveFlight")
	public String saveFlight(@ModelAttribute("flight") Flight flight) {
		flightService.saveFlight(flight);
		return "redirect:/flight/list ";
	}
	
	@GetMapping("/deleteFlight")
	public String deleteFlight(@RequestParam("flightId") int id) {
		flightService.deleteFlight(id);
		return "redirect:/flight/list";
	}
	
	@GetMapping("/searchFlight")
	public String searchFlight(@RequestParam("departureName") String departureName, Model model) {
		List<Flight> flights = flightService.searchFlightByDeparture(departureName);
		model.addAttribute("flights", flights);
		return "list-flights";
	}
	
	@ModelAttribute("airports")
	public List<Airport> getAirports() {
		return airportService.getAirports();
	}
}
