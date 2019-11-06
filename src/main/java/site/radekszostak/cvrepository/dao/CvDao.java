package site.radekszostak.cvrepository.dao;

import java.util.List;

import site.radekszostak.cvrepository.entity.Cv;

public interface CvDao {

    public Cv findByUserName(String userName);
    
    public void save(Cv cv);

	public List<Cv> findAllPublic();

	public Cv findById(int cvId);
    
}
