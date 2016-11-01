package cooksys.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cooksys.entity.AppRole;
import cooksys.service.RoleService;

@RestController
@RequestMapping("cuttlefern")
public class CuttlefernController {

	private RoleService roleService;

	public CuttlefernController(RoleService roleService) {
		this.roleService = roleService;
	}
	
	@GetMapping("role/{id}")
	public AppRole getAppRole(@PathVariable long id) {
		return roleService.getById(id);
	}
	
	@GetMapping("role")
	public List<AppRole> getAllAppRoles() {
		return roleService.getAll();
	}
	
	@GetMapping("role/title/{name}")
	public AppRole getAppRoleByName(@PathVariable String name) {
		return roleService.getByName(name);
	}
}
