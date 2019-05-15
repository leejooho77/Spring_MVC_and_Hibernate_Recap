package com.java.flight.tracker.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
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
		// create a query
		Query<Flight> query = session.createQuery("from Flight", Flight.class);
		// execute query and get result list
		List<Flight> flights = query.list();
		// return list
		return flights;
	}
	
}
