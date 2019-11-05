package site.radekszostak.cvrepository.dao;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import site.radekszostak.cvrepository.entity.Cv;

@Repository
public class CvDaoImpl implements CvDao {
	
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public Cv findByUserName(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Cv theCv) {
		// get current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		System.out.println("===> cv in CvDAO: " + theCv);
		// create the user ... finally LOL
		currentSession.saveOrUpdate(theCv);
	}

}
