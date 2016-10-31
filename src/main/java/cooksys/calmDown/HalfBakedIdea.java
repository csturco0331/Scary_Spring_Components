package cooksys.calmDown;

import java.util.Set;

import org.springframework.stereotype.Component;

import cooksys.component.LoggerComponent;
import cooksys.interfaces.ActionExecutor;
import cooksys.interfaces.ConditionalThing;

@Component
public class HalfBakedIdea {
	
	private Set<ActionExecutor> actions;
	LoggerComponent logger;
	int totalActions;

	public HalfBakedIdea(Set<ActionExecutor> actions, LoggerComponent logger) {
		this.actions = actions;
		this.logger = logger;
	}

	public void doThings(ConditionalThing o) {
		logger.logIt("I'm taking " + actions.size() + " actions!");
		totalActions += actions.size();
		actions.forEach(action -> action.takeAction(o));
	}
	
	public Integer getTotalActions() {
		return totalActions;
	}
}
