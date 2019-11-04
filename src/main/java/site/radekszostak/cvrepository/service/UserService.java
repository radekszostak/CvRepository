package site.radekszostak.cvrepository.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import site.radekszostak.cvrepository.entity.User;
import site.radekszostak.cvrepository.user.CrmUser;

public interface UserService extends UserDetailsService {

	public User findByUserName(String userName);

	public void save(CrmUser crmUser);
}
