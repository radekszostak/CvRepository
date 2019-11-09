package site.radekszostak.cvrepository.service;

public interface PhotoService {

    void store(byte[] bytes, String name) throws Exception;

    byte[] load(String filename);
    
}