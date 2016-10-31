package cooksys.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cooksys.calmDown.HalfBakedIdea;
import cooksys.component.AlterMessage;

@RestController
@RequestMapping("message")
public class MessageController {
	
	AlterMessage message;
	HalfBakedIdea count;
	
	public MessageController(AlterMessage msg, HalfBakedIdea count) {
		message = msg;
		this.count = count;
	}
	
	@GetMapping
	public AlterMessage getMessage() {
		return message;
	}
	
	@GetMapping("count")
	public Integer getCharacterCount() {
		return message.getMessage().length();
	}
	
	@GetMapping("actions")
	public int actions() {
		return count.getCounter();
	}

}
