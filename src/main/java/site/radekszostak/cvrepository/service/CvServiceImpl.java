package site.radekszostak.cvrepository.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import site.radekszostak.cvrepository.dao.CvDao;
import site.radekszostak.cvrepository.dao.UserDao;
import site.radekszostak.cvrepository.entity.Cv;

@Service
public class CvServiceImpl implements CvService {
	
	@Autowired
	private CvDao cvDao;
	
	@Override
	public List<Cv> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cv findByUserId(int theId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public void save(Cv theCv) {
		cvDao.save(theCv);

	}

	@Override
	public void deleteById(int theId) {
		// TODO Auto-generated method stub

	}

}
