package site.radekszostak.cvrepository.dao;

import site.radekszostak.cvrepository.entity.Cv;

public interface CvDao {

    public Cv findByUserName(String userName);
    
    public void save(Cv cv);
    
}
