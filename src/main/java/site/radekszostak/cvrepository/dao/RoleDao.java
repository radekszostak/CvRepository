package site.radekszostak.cvrepository.dao;

import site.radekszostak.cvrepository.entity.Role;

public interface RoleDao {

	public Role findRoleByName(String theRoleName);
	
}
