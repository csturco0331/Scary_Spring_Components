package cooksys.repository.impl;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import cooksys.entity.AppRole;
import cooksys.repository.RoleRepository;

@Repository
public class RoleRepositoryImpl implements RoleRepository {

	EntityManager entityManager;
	
	public RoleRepositoryImpl(EntityManager em) {
		entityManager = em;
	}
	
	@Override
	public AppRole get(long id) {
		return entityManager.find(AppRole.class, id);
	}

}
