package cooksys.calmDown;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import cooksys.component.LoggerComponent;
import cooksys.interfaces.ActionExecutor;
import cooksys.interfaces.ConditionalThing;

@Component
public class HalfBakedIdea {
	
	private Set<ActionExecutor> actions;
	LoggerComponent logger;

	public HalfBakedIdea(Set<ActionExecutor> actions, LoggerComponent logger) {
		this.actions = actions;
		this.logger = logger;
	}

	public void doThings(ConditionalThing o) {
		logger.logIt("I'm taking some actions!");
		actions.forEach(action -> action.takeAction(o));
	}
}
