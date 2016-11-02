package cooksys.repository;

import cooksys.entity.Technique;

public interface TechniqueRepository {

	Technique get(long id);

	Technique get(String desc);
	
}
