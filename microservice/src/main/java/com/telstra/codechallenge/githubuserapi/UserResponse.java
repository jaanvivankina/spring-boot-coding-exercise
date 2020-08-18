package com.telstra.codechallenge.githubuserapi;

public class UserResponse {

	private long id;
	private String login;
	private String html_url;

	public UserResponse() {

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
		return "UserResponse [id=" + id + ", login=" + login + ", html_url=" + html_url + "]";
	}

}
