package cooksys.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import cooksys.entity.AppUser;
import cooksys.projections.AppUserProjection;
import cooksys.repository.UserRepository;
import cooksys.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	UserRepository userRepo;
	
	public UserServiceImpl(UserRepository userRepo) {
		this.userRepo = userRepo;
	}

	@Override
	public List<AppUser> getUsersByStateIgnoreCase(String stateName) {
		return userRepo.findByStateIgnoreCase(stateName);
	}
	
	public List<AppUserProjection> getUsersByCityAndStateIgnoreCase(String city, String state) {
		return userRepo.findNameByCityIgnoreCaseAndStateIgnoreCase(city, state);
	}

	@Override
	public AppUser alterUser(AppUser user) {
		System.out.println(user);
		return userRepo.saveAndFlush(user);
	}

}
