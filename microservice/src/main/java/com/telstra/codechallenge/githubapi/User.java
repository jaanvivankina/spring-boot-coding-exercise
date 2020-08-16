package com.telstra.codechallenge.githubapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@JsonDeserialize
public class User {

	private String total_count;
	private Items items;

	@JsonIgnoreProperties(ignoreUnknown = true)
	@JsonRootName(value = "items")
	@Data
	public class Items {
		
		private Long id;
		private String login;
		private String htmlUrl;
	}

}
