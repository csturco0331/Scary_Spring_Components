package cooksys.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cooksys.calmDown.Message;

@RestController
@RequestMapping("message")
public class MessageController {
	
	Message message;
	
	public MessageController(Message msg) {
		message = msg;
	}
	
	@GetMapping
	public Message getMessage() {
		return message;
	}
	
	@GetMapping("count")
	public Integer getCharacterCount() {
		return message.getMessage().length();
	}
		

}
