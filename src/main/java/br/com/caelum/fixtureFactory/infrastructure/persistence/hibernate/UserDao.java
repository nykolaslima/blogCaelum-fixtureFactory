package br.com.caelum.fixtureFactory.infrastructure.persistence.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.caelum.fixtureFactory.domain.model.City;
import br.com.caelum.fixtureFactory.domain.model.User;

public class UserDao {
	
	private final Session session;
	
	public UserDao(Session session) {
		this.session = session;
	}
	
	@SuppressWarnings("unchecked")
	public List<User> findByCity(City city) {
		return session.createCriteria(User.class)
				.createAlias("address", "address")
				.add(Restrictions.eq("address.city", city)).list();
	}

}
