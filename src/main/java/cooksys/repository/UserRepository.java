package cooksys.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cooksys.entity.AppUser;
import cooksys.projections.AppUserProjection;

public interface UserRepository extends JpaRepository<AppUser, Long> {
	
	List<AppUser> findByStateIgnoreCase(String state);

	List<AppUserProjection> findNameByCityIgnoreCaseAndStateIgnoreCase(String city, String state);
	
}