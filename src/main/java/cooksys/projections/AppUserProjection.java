package cooksys.projections;

import org.springframework.beans.factory.annotation.Value;

public interface AppUserProjection {

	String getName();
	
	@Value("#{target.city}, #{target.state}")
	String getLocation();
	
}
