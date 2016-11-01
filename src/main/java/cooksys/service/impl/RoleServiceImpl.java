package cooksys.service.impl;

import org.springframework.stereotype.Service;

import cooksys.entity.AppRole;
import cooksys.repository.RoleRepository;

@Service
public class RoleServiceImpl {
	
	private RoleRepository roleRepo;

	public RoleServiceImpl(RoleRepository roleRepo) {
		this.roleRepo = roleRepo;
	}
	
	public AppRole getById(long id) {
		return roleRepo.get(id);
	}

}
