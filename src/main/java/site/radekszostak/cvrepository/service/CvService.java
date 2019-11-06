package site.radekszostak.cvrepository.service;


import java.util.List;


import site.radekszostak.cvrepository.entity.Cv;

public interface CvService {

	public List<Cv> findAll();
	
	public List<Cv> findAllPublic();

	public Cv findByUserId(int theId);

	public void save(Cv theCv);

	public void deleteById(int theId);

	public Cv findById(int cvId);

}
