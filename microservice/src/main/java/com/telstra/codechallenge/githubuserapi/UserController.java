package com.telstra.codechallenge.githubuserapi;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	private static final Logger log = LoggerFactory.getLogger(UserController.class);

	private UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<UserResponse> getOlddestUsers(@RequestParam(value = "perpage", defaultValue = "3") String perpage) {
		log.info("UserController Before calling API::");
		List<UserResponse> userResponseList = null;
		userResponseList = userService.getOlddestUsers(perpage);
		boolean empty = userResponseList.isEmpty();
		if(empty)
			log.info("UserController getOlddestUsers list is empty");
		else
			log.info("UserController getOlddestUsers response"+userResponseList.toString());
		return userResponseList;
	}

}
