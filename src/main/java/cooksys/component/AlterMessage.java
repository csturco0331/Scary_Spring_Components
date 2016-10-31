package cooksys.component;

import org.springframework.stereotype.Component;

import cooksys.calmDown.HalfBakedIdea;
import cooksys.calmDown.Message;
import cooksys.interfaces.ConditionalThing;
import cooksys.interfaces.Printable;

@Component
public class AlterMessage implements Printable, ConditionalThing {

//	Logger log = LoggerFactory.getLogger(AlterMessage.class);

	Message msg;

	public AlterMessage(HalfBakedIdea actionz, Message msg) {
		
		msg.setMessage("ZALTER MUST SPEAK NOW");
		this.msg = msg;
		actionz.doThings(this);
	}

	@Override
	public String getMessage() {
		return msg.getMessage();
	}

	@Override
	public String toString() {
		return getMessage();
	}

	@Override
	public boolean isCondition() {
		// TODO Auto-generated method stub
		return true;
	}
}
