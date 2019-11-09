package site.radekszostak.cvrepository.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import site.radekszostak.cvrepository.dao.CvDao;
import site.radekszostak.cvrepository.entity.Cv;

@Service
public class CvServiceImpl implements CvService {
	
	@Autowired
	private CvDao cvDao;
	
	@Override
	@Transactional
	public List<Cv> findAllPublic() {
		return cvDao.findAllPublic();
	}

	@Override
	@Transactional
	public Cv findById(int cvId) {
		return cvDao.findById(cvId);
	}

	@Override
	@Transactional
	public void save(Cv theCv) {
		cvDao.save(theCv);

	}
}
