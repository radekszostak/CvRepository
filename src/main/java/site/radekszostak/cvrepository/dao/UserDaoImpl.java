package site.radekszostak.cvrepository.dao;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import site.radekszostak.cvrepository.entity.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private EntityManager entityManager;

	@Override
	public User findByUserName(String theUserName) {

		Session currentSession = entityManager.unwrap(Session.class);
		Query<User> theQuery = currentSession.createQuery("from User where username=:uName", User.class);
		theQuery.setParameter("uName", theUserName);
		User theUser = null;
		try {
			theUser = theQuery.getSingleResult();
		} catch (Exception e) {
			theUser = null;
		}

		return theUser;
	}

	@Override
	public void save(User theUser) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(theUser);
	}

}
