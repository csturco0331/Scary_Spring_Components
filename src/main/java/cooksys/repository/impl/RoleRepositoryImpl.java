package cooksys.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cooksys.component.LoggerComponent;
import cooksys.entity.AppRole;
import cooksys.repository.RoleRepository;

@Repository
public class RoleRepositoryImpl implements RoleRepository {

	EntityManager entityManager;
	LoggerComponent logger;
	
	public RoleRepositoryImpl(EntityManager em, LoggerComponent logger) {
		entityManager = em;
		this.logger = logger;
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

	@Override
	@Transactional
	public long create(AppRole appRole) {
		logger.logIt("Current appRole ID: " + appRole.getId());
		
		// Persist = Mutable
		// Persist modifies the entity that was passed to it to match what is in the database
		entityManager.persist(appRole);
		return appRole.getId();
		
		// Merge = Immutable
		// Returns a new object that matches what is in the database
		// AppRole newEntity = entityManager.merge(appRole);
		// return newEntity.getId();
	}

}
