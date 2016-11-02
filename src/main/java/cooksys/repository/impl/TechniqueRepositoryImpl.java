package cooksys.repository.impl;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import cooksys.entity.Technique;
import cooksys.repository.TechniqueRepository;

@Repository
public class TechniqueRepositoryImpl implements TechniqueRepository {

	EntityManager entityManager;
	
	public TechniqueRepositoryImpl(EntityManager em) {
		entityManager = em;
	}
	
	@Override
	public Technique get(long id) {
		return entityManager.find(Technique.class, id);
	}

	@Override
	public Technique get(String desc) {
		return entityManager
				.createQuery("from Technique where description = :desc", Technique.class)
				.setParameter("desc", desc)
				.getSingleResult();
	}

}
