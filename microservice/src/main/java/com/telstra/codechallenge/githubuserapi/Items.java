package com.telstra.codechallenge.githubuserapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Items {

	private long id;
	private String login;
	private String html_url;

	public Items() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getHtml_url() {
		return html_url;
	}

	public void setHtml_url(String html_url) {
		this.html_url = html_url;
	}

	@Override
	public String toString() {
		return "Items [id=" + id + ", login=" + login + ", html_url=" + html_url + "]";
	}

}
