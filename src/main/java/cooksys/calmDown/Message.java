package cooksys.calmDown;

import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_PROTOTYPE;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import cooksys.interfaces.ConditionalThing;
import cooksys.interfaces.Printable;

@Component
@Scope(SCOPE_PROTOTYPE)
public class Message implements Printable, ConditionalThing {
	
	//Logger log = LoggerFactory.getLogger(Message.class);
	
	private String msg;
	
	public Message(HalfBakedIdea actionz) {
		msg = "Hey there!";
		actionz.doThings(this);
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String getMessage() {
		return msg;
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