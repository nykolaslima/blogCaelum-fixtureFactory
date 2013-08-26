package br.com.caelum.fixtureFactory.infrastructure.persistence.hibernate;

import org.hibernate.Session;

import br.com.caelum.fixtureFactory.domain.model.City;
import br.com.caelum.fixtureFactory.domain.model.User;

public class UserDao {
	
	private final Session session;
	
	public UserDao(Session session) {
		this.session = session;
	}
	
	public User findByCity(City city) {
		return null;
	}

}
