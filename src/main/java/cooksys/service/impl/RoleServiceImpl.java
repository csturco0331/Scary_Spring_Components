package cooksys.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import cooksys.entity.AppRole;
import cooksys.repository.RoleRepository;
import cooksys.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
	
	private RoleRepository roleRepo;

	public RoleServiceImpl(RoleRepository roleRepo) {
		this.roleRepo = roleRepo;
	}
	
	public AppRole getById(long id) {
		return roleRepo.get(id);
	}

	@Override
	public List<AppRole> getAll() {
		return roleRepo.getAll();
	}

	@Override
	public AppRole getByName(String name) {
		return roleRepo.getByName(name);
	}

}
