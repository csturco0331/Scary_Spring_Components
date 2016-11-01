package cooksys.repository;

import cooksys.entity.Person;

public interface PersonRepository {

	Person get(long id);
	
}
