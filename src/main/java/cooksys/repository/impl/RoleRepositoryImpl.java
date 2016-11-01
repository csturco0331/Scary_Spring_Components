package cooksys.repository.impl;

import java.util.List;

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
	
	@Override
	public AppRole getByName(String roleName) {
		return entityManager
				.createQuery("from AppRole where roleTitle = :roleNameValue", AppRole.class)
				.setParameter("roleNameValue", roleName)
				.getResultList()
				.get(0);
	}

	@Override
	public List<AppRole> getAll() {
		return entityManager.createQuery("from AppRole", AppRole.class).getResultList();
	}

}
