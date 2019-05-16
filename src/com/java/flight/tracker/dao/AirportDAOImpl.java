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
		Query<Airport> query = session.createQuery("FROM Airport ORDER BY name", Airport.class);
		return query.list();
	}
	
	@Override
	public List<Integer> getIdByCountry(String name) {
		// get current hibernate session
		Session session = sessionFactory.getCurrentSession();
		// get corresponding data and return
		List<Integer> ids = null;
		if(name != null && name.trim().length() > 0) {
			ids = session.createQuery("SELECT a.id FROM Airport a WHERE lower(a.country) LIKE (:name)", Integer.class)
					  	 .setParameter("name", "%" + name.toLowerCase() + "%")
					  	 .list();
		} else {
			ids = session.createQuery("SELECT a.id FROM Airport a", Integer.class)
						 .list();
		}
		return ids;
	}

}
