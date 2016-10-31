package cooksys.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import cooksys.interfaces.ActionExecutor;
import cooksys.interfaces.ConditionalThing;

@Component
public class LoggerComponent implements ActionExecutor {

	Logger log = LoggerFactory.getLogger(LoggerComponent.class);
	
	@Override
	public void takeAction(ConditionalThing o) {
		if(o.isCondition())
			log.info(o.toString());
	}
	
	public void logIt(Object o) {
		log.info(o.toString());
	}

}
