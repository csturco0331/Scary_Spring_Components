package cooksys.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cooksys.DataTransferObject;
import cooksys.calmDown.HalfBakedIdea;
import cooksys.calmDown.Message;

@RestController
@RequestMapping("message")
public class MessageController {

	Message message;
	HalfBakedIdea halfBaked;
	Map<String, List<String>> userMessages = new HashMap<>();

	public MessageController(Message msg, HalfBakedIdea halfBaked) {
		message = msg;
		this.halfBaked = halfBaked;
	}

	@GetMapping
	public Message getMessage() {
		return message;
	}

	
	/**
	 * Use a Map<String, String> to accept any arbitrary JSON object as key-value pairs
	 * @param incoming
	 * @return
	 */
	@PostMapping
	public String postMessage(@RequestBody Map<String, String> incoming) {

		StringBuffer b = new StringBuffer();

		incoming.entrySet().forEach(
				
				entry -> b.append(entry.getKey() + " HAS A VALUE OF " + entry.getValue() + "\n")
				
				);

		return b.toString();
	}
	
	/**
	 * Use a POJO to cause Spring to marshal the incoming JSON as a particular object
	 * @param incoming
	 * @return
	 */
	@PutMapping
	public String putMessage(@RequestBody DataTransferObject incoming) {

		 System.out.println(incoming.getValue());
		 return incoming.getValue();
	}

	@GetMapping("count")
	public Integer getCharacterCount() {
		return message.getMessage().length();
	}
	
	@GetMapping("/user/{username}")
	public List<String> getDataFromUser(@PathVariable String username ) {
		return userMessages.remove(username);
	}
	
	@PutMapping("/user/{username}")
	public void putDataToUser(@PathVariable String username, @RequestBody DataTransferObject msg) {
		if(userMessages.containsKey(username)) userMessages.get(username).add(msg.getValue());
		else userMessages.put(username, new LinkedList<String>(Arrays.asList(msg.getValue())));
	}

	/**
	 * Add a new method here! This method will cause postman to respond with the
	 * total number of actions taken by the system (see @HalfBakedIdea) when a
	 * GET request is sent to "http://localhost:8080/message/actions"
	 */
	@GetMapping("actions")
	public Integer getNumberOfActions() {
		return halfBaked.getTotalActions();
	}

}
