package cooksys.service;

import cooksys.entity.Technique;

public interface TechniqueService {

	public Technique getById(long id);

	public Technique getByName(String desc);
	
}
