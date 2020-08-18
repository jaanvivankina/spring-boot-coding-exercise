package com.telstra.codechallenge.githubuserapi;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserRequest {

	private long total_count;
	private List<Items> items;

	public UserRequest() {

	}

	public long getTotal_count() {
		return total_count;
	}

	public void setTotal_count(long total_count) {
		this.total_count = total_count;
	}

	public List<Items> getItems() {
		return items;
	}

	public void setItems(List<Items> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "UserRequest [total_count=" + total_count + ", items=" + items + "]";
	}

}
