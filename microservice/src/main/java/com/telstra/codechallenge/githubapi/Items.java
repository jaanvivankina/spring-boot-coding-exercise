package com.telstra.codechallenge.githubapi;

import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Data;

@JsonRootName(value = "items")
@Data
public class Items {
	private Long id;
	private String login;
	private String htmlUrl;
}
