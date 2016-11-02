package cooksys.repository.impl;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import cooksys.entity.Person;
import cooksys.repository.PersonRepository;

@Repository
public class PersonRepositoryImpl implements PersonRepository {

	EntityManager entityManager;
	
	public PersonRepositoryImpl(EntityManager em) {
		entityManager = em;
	}
	
	@Override
	public Person get(long id) {
		return entityManager.find(Person.class, id);
	}

}
