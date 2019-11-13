package site.radekszostak.cvrepository.dao;

import java.util.List;
import java.util.TimeZone;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import site.radekszostak.cvrepository.entity.Cv;

@Repository
public class CvDaoImpl implements CvDao {
	
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public void save(Cv theCv) {
		Session currentSession = entityManager.unwrap(Session.class);
	
		currentSession.saveOrUpdate(theCv);
	}

	@Override
	public List<Cv> findAllPublic() {
		Session currentSession = entityManager.unwrap(Session.class);

		Query<Cv> theQuery = currentSession.createQuery("from Cv where publish=1", Cv.class);
		List<Cv> theCvs;
		try {
			theCvs = theQuery.getResultList();
		} catch (Exception e) {
			theCvs = null;
		}
		return theCvs;
	}

	@Override
	public Cv findById(int cvId) {

		Session currentSession = entityManager.unwrap(Session.class);
		Query<Cv> theQuery = currentSession.createQuery("from Cv where id=:cvId", Cv.class);
		theQuery.setParameter("cvId", cvId);
		Cv theCv = null;
		try {
			theCv = theQuery.getSingleResult();
		} catch (Exception e) {
			theCv = null;
		}
		return theCv;
	}

}
