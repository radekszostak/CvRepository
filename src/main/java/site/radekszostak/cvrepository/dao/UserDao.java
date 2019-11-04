package site.radekszostak.cvrepository.dao;

import site.radekszostak.cvrepository.entity.User;

public interface UserDao {

    public User findByUserName(String userName);
    
    public void save(User user);
    
}
