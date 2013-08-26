package br.com.caelum.fixtureFactory.infrastructure.persistence.hibernate.withoutFixtureFactory;

import static junit.framework.Assert.assertTrue;

import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.caelum.fixtureFactory.domain.model.Address;
import br.com.caelum.fixtureFactory.domain.model.City;
import br.com.caelum.fixtureFactory.domain.model.State;
import br.com.caelum.fixtureFactory.domain.model.User;
import br.com.caelum.fixtureFactory.infrastructure.persistence.hibernate.HibernateUtil;
import br.com.caelum.fixtureFactory.infrastructure.persistence.hibernate.UserDao;

public class UserDaoTest {

	private User user;
	private City city;
	private Session session;
	
	@Before
	public void setUp() {
		session = HibernateUtil.currentSession();
		HibernateUtil.beginTransaction();
		
		State state = new State();
		state.setName("São Paulo");
		session.save(state);
		
		city = new City();
		city.setName("São Paulo");
		session.save(city);
		
		Address address = new Address();
		address.setStreet("Rua Xpto");
		address.setState(state);
		address.setCity(city);
		session.save(address);
		
		user = new User();
		user.setUsername("nykolaslima");
		user.setAddress(address);
		session.save(user);
	}
	
	@After
	public void tearDown() {
		HibernateUtil.rollbackTransaction();
		HibernateUtil.closeSession();
	}
	
	@Test
	public void shouldFindUserByCity() {
		UserDao userDao = new UserDao(HibernateUtil.currentSession());
		
		assertTrue(userDao.findByCity(city).contains(user));
	}

}
