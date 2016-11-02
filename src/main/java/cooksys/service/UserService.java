package cooksys.service;

import java.util.List;

import cooksys.entity.AppUser;
import cooksys.projections.AppUserProjection;

public interface UserService {

	List<AppUser> getUsersByStateIgnoreCase(String stateName);
	
	List<AppUserProjection> getUsersByCityAndStateIgnoreCase(String city, String state);

	AppUser alterUser(AppUser user);

}
