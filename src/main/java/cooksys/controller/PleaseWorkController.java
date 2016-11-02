package cooksys.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cooksys.entity.Technique;
import cooksys.service.TechniqueService;

@RestController
@RequestMapping("pleasework")
public class PleaseWorkController {

	private TechniqueService techService;
	
	public PleaseWorkController(TechniqueService ts) {
		techService = ts;
	}
	
	@GetMapping("technique/{id}")
	public Technique getTechnique(@PathVariable long id) {
		return techService.getById(id);
	}
	
	@GetMapping("technique/name/{desc}") 
	public Technique getTechByName(@PathVariable String desc) {
		return techService.getByName(desc);
	}
	
}
