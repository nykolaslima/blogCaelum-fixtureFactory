package br.com.caelum.fixtureFactory.infrastructure.persistence.hibernate.withFixtureFactory;

import static junit.framework.Assert.assertTrue;

import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.caelum.fixtureFactory.domain.model.User;
import br.com.caelum.fixtureFactory.infrastructure.persistence.hibernate.HibernateUtil;
import br.com.caelum.fixtureFactory.infrastructure.persistence.hibernate.UserDao;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;

public class UserDaoTest {

	private Session session;
	private UserDao userDao;
	
	@BeforeClass
	public static void setUpClass() {
		FixtureFactoryLoader.loadTemplates("br.com.caelum.fixtureFactory.infrastructure.fixture");
	}
	
	@Before
	public void setUp() {
		session = HibernateUtil.currentSession();
		userDao = new UserDao(session);
		HibernateUtil.beginTransaction();
	}
	
	@After
	public void tearDown() {
		HibernateUtil.rollbackTransaction();
		HibernateUtil.closeSession();
	}
	
	@Test
	public void shouldFindUserByCity() {
		User user = Fixture.from(User.class, session).gimme("valid");
		
		assertTrue(userDao.findByCity(user.getAddress().getCity()).contains(user));
	}
	
}
