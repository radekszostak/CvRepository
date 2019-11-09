package site.radekszostak.cvrepository.service;


import java.util.List;


import site.radekszostak.cvrepository.entity.Cv;

public interface CvService {

	public List<Cv> findAllPublic();

	public void save(Cv theCv);

	public Cv findById(int cvId);

}
