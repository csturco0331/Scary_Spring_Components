package cooksys.service;

import java.util.List;

import cooksys.entity.AppRole;

public interface RoleService {
	
	public AppRole getById(long id);

	public List<AppRole> getAll();

	public AppRole getByName(String name);

	public long create(AppRole appRole);

}
