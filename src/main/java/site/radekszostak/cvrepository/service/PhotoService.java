package site.radekszostak.cvrepository.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

public interface PhotoService {

    void init();

    void store(byte[] bytes, String name) throws Exception;

    Stream<Path> loadAll();

    byte[] load(String filename);

    Resource loadAsResource(String filename);

    void deleteAll();

}