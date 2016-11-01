package cooksys.service.impl;

import org.springframework.stereotype.Service;

import cooksys.entity.Person;
import cooksys.repository.PersonRepository;
import cooksys.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService {

	private PersonRepository personRepo;
	
	public PersonServiceImpl(PersonRepository personRepo) {
		this.personRepo = personRepo;
	}
	
	@Override
	public Person getById(long id) {
		return personRepo.get(id);
	}

}
