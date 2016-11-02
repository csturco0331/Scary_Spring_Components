package cooksys.service.impl;

import org.springframework.stereotype.Service;

import cooksys.entity.Technique;
import cooksys.repository.TechniqueRepository;
import cooksys.service.TechniqueService;

@Service
public class TechniqueServiceImpl implements TechniqueService {

	TechniqueRepository techRepo;
	
	public TechniqueServiceImpl(TechniqueRepository tr) {
		techRepo = tr;
	}
	
	@Override
	public Technique getById(long id) {
		return techRepo.get(id);
	}

	@Override
	public Technique getByName(String desc) {
		return techRepo.get(desc);
	}

}
