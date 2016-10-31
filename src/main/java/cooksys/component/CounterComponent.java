package cooksys.component;

import org.springframework.stereotype.Component;

import cooksys.interfaces.ActionExecutor;
import cooksys.interfaces.ConditionalThing;

@Component
public class CounterComponent implements ActionExecutor {

	int counter = 0;
	
	LoggerComponent logger;
	
	public CounterComponent(LoggerComponent logger) {
		this.logger = logger;
	}
	
	@Override
	public void takeAction(ConditionalThing o) {
		
		if(o.isCondition()) {
			counter++;
			logger.logIt(counter);
		}
	}
	
	public int getCounter() {
		return counter;
	}
	
}
