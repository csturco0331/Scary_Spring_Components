package cooksys.component;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import cooksys.interfaces.Printable;

@Component
public class Printer {

	Logger log = LoggerFactory.getLogger(Printer.class);
	
	public Printer(Set<Printable> msg) {
		
		msg.forEach(printable -> log.info(printable.getMessage()));
		
	}

}