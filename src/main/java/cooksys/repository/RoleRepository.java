package cooksys.repository;

import java.util.List;

import cooksys.entity.AppRole;

public interface RoleRepository {
	
	AppRole get(long id);

	AppRole getByName(String roleName);

	List<AppRole> getAll();

}
