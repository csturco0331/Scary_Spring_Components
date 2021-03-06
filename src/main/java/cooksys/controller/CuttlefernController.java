package cooksys.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cooksys.entity.AppRole;
import cooksys.entity.Person;
import cooksys.service.PersonService;
import cooksys.service.RoleService;

@RestController
@RequestMapping("cuttlefern")
public class CuttlefernController {

	private RoleService roleService;
	private PersonService personService;

	public CuttlefernController(RoleService roleService, PersonService personService) {
		this.roleService = roleService;
		this.personService = personService;
	}
	
	@GetMapping("role/{id}")
	public AppRole getAppRole(@PathVariable long id) {
		return roleService.getById(id);
	}
	
	@GetMapping("person/{id}")
	public Person getPerson(@PathVariable long id) {
		return personService.getById(id);
	}

	@GetMapping("role")
	public List<AppRole> getAllAppRoles() {
		return roleService.getAll();
	}
	
	@GetMapping("role/title/{name}")
	public AppRole getAppRoleByName(@PathVariable String name) {
		return roleService.getByName(name);
	}
	
	@PostMapping("role")
	public long postAppRole(@RequestBody AppRole appRole) {
		return roleService.create(appRole);
	}
	//Adding comment here to test github merging issues
}
