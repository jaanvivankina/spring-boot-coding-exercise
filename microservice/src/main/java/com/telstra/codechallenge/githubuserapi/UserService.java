package com.telstra.codechallenge.githubuserapi;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {
	
	private static final Logger log = LoggerFactory.getLogger(UserService.class);

	@Value("${github.base.url}")
	private String githubBaseUrl;

	private RestTemplate restTemplate;

	public UserService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public List<UserResponse> getOlddestUsers(String perpage) {
		List<UserResponse> userResponseList = new ArrayList<UserResponse>();
		String url = githubBaseUrl + "/search/users?q=followers:0&sort=joined&order=asc&per_page=" + perpage;
		try {
			UserRequest userRequest = restTemplate.getForObject(url, UserRequest.class);
			log.info("UserService getOlddestUsers response"+userRequest.toString());
			List<Items> itemList = userRequest.getItems();
			itemList.stream()
				.filter(list -> (itemList != null && !itemList.isEmpty()))
				.forEach((u) -> {
				UserResponse userResponse = new UserResponse();
				userResponse.setLogin(u.getLogin());
				userResponse.setId(u.getId());
				userResponse.setHtml_url(u.getHtml_url());
				userResponseList.add(userResponse);
			});
		} catch (RestClientException e) {
			log.error("UserService getOlddestUsers error response"+e);
		}
		return userResponseList;
	}
}
