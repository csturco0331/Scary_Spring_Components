package cooksys.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cooksys.entity.AppRole;
import cooksys.entity.AppUser;
import cooksys.projections.AppUserProjection;
import cooksys.service.UserService;

@RestController
@RequestMapping("user")
public class UserController {
	
	private UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/{user}")
	public AppUser getUser(@PathVariable AppUser user) {
		return user;
	}
	
	@GetMapping("/{user}/role")
	public AppRole getUserRole(@PathVariable AppUser user) {
		return user.getRole();
	}
	
	@GetMapping("/state/{stateName}")
	public List<AppUser> getUsersByState(@PathVariable String stateName) {
		return userService.getUsersByStateIgnoreCase(stateName);
	}
	
	@GetMapping("/state/{stateName}/{cityName}")
	public List<AppUserProjection> getUsersByState(@PathVariable String stateName, @PathVariable String cityName) {
		return userService.getUsersByCityAndStateIgnoreCase(cityName, stateName);
	}
	
	@PutMapping("/{id}")
	public AppUser alterUser(@PathVariable int id, @RequestBody AppUser user) {
		user.setId(id);
		return userService.alterUser(user);
	}
}
