package com.telstra.codechallenge.githubapi;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	private UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET, produces = "application/json")
	public User getSearchUsers(@RequestParam(value = "per_page", defaultValue = "3") String per_page) {

		User user = userService.searchUsers(per_page);
		return user;

	}

}
