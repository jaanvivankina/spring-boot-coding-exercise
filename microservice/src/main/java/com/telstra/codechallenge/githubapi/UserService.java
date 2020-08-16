package com.telstra.codechallenge.githubapi;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {

	@Value("${github.base.url}")
	private String githubBaseUrl;

	private RestTemplate restTemplate;

	public UserService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	/**
	 * @param url
	 *
	 * @return - a user array
	 *         https://api.github.com/search/users?q=followers:0&sort=joined&order=asc&per_page=3
	 */

	public Object getUsers(String per_page) {
		// String url =
		// "https://api.github.com/search/users?q=followers:0&sort=joined&order=asc&per_page=3";
		// String url = "https://jsonplaceholder.typicode.com/todos";
		String url = githubBaseUrl + "/search/users?q=followers:0&sort=joined&order=asc&per_page=" + per_page;
		System.out.println("url--->" + url);
		String jsonString = restTemplate.getForObject(url, String.class);

		JsonParser springParser = JsonParserFactory.getJsonParser();
		Map<String, Object> map = springParser.parseMap(jsonString);

		String mapArray[] = new String[map.size()];
		System.out.println("Items found: " + mapArray.length);
		System.out.println("Items : " + map.values().toArray()[2]);

		int i = 0;
		for (Map.Entry<String, Object> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " = " + entry.getValue());
			i++;
		}

		return map.values().toArray()[2];

		/*
		 * // create headers HttpHeaders headers = new HttpHeaders();
		 * headers.setContentType(MediaType.APPLICATION_JSON);
		 * headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		 * 
		 * // build the request HttpEntity request = new HttpEntity(headers);
		 * 
		 * // make an HTTP GET request with headers ResponseEntity<UserSearch[]>
		 * response = restTemplate.exchange( url, HttpMethod.GET, request,
		 * UserSearch[].class );
		 * 
		 * // check response if (response.getStatusCode() == HttpStatus.OK) {
		 * System.out.println("Request Successful.");
		 * System.out.println(response.getBody()); }else
		 * 
		 * { System.out.println("Request Failed");
		 * System.out.println(response.getStatusCode()); }return
		 * response.getBody().clone();
		 */
	}

	public User searchUsers(String per_page) {
		// String url = "https://api.github.com/search/users?q=followers:0&sort=joined&order=asc&per_page=3";
		String url = githubBaseUrl + "/search/users?q=followers:0&sort=joined&order=asc&per_page=" + per_page;
		System.out.println("url--->" + url);
		User user = restTemplate.getForObject(url, User.class);

		return user;
	}
}
