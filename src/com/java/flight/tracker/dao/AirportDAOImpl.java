package com.java.flight.tracker.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.java.flight.tracker.entity.Airport;

@Repository
public class AirportDAOImpl implements AirportDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public List<Airport> getAirports() {
		// get current hibernate session
		Session session = sessionFactory.getCurrentSession();
		// get list of airports
		Query<Airport> query = session.createQuery("from Airport order by name", Airport.class);
		return query.list();
	}

}
