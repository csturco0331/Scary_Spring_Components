package cooksys.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cooksys.entity.AppRole;
import cooksys.service.impl.RoleServiceImpl;

@RestController
@RequestMapping("cuttlefern")
public class CuttlefernController {

	private RoleServiceImpl roleService;

	public CuttlefernController(RoleServiceImpl roleService) {
		this.roleService = roleService;
	}
	
	@GetMapping("role/{id}")
	public AppRole getAppRole(@PathVariable long id) {
		return roleService.getById(id);
	}
}
