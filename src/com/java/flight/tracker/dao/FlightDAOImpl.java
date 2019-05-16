package com.java.flight.tracker.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.java.flight.tracker.entity.Flight;

@Repository
public class FlightDAOImpl implements FlightDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public List<Flight> getFlights() {
		// get current session
		Session session = sessionFactory.getCurrentSession();
		// create a query, sort by flight number
		return session.createQuery("FROM Flight ORDER BY flightNumber", Flight.class)
					  .list();
	}
	
	@Override
	public List<Flight> searchFlightByDeparture(List<Integer> airportsId) {
		// get current hibernate session
		Session session = sessionFactory.getCurrentSession();
		List<Flight> flights = null;
		// create a query and return it
		if(airportsId == null || airportsId.size() == 0) {
			flights = session.createQuery("FROM Flight f", Flight.class)
							 .list();
		} else {
			flights = session.createQuery("FROM Flight f WHERE f.departure.id IN (:ids)", Flight.class)
					  		 .setParameter("ids", airportsId)
					  		 .list();
		}
		return flights;
	}
	
	@Override
	public Flight getFlight(int id) {
		// get current session
		Session session = sessionFactory.getCurrentSession();
		// get flight info by id and return it
		return session.get(Flight.class, id);
	}

	@Override
	public void saveFlight(Flight flight) {
		// get current hibernate session
		Session session = sessionFactory.getCurrentSession();
		// save the flight
		session.saveOrUpdate(flight);
	}
	
	@Override
	public void deleteFlight(int id) {
		// get current hibernate session
		Session session = sessionFactory.getCurrentSession();
		// delete the flight by id
		session.createQuery("DELETE FROM Flight f WHERE f.id=:flightId")
			   .setParameter("flightId", id)
			   .executeUpdate();
	}
	
}
