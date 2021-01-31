package rs.istv.service;

import java.util.Collection;
import java.util.List;
import rs.istv.entity.*;

public  interface RoleService {

	List<Role> findAll();

	Role save(Role role);

	Role update(Role role);

	Role findById(Integer roleId);

	void deleteById(Integer roleId);

}