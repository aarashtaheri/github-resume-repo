package com.arash.githubresume;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NodeDTO_2del {
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("full_name")
	private String fullName;

	@JsonProperty("forks_count")
	private Integer forksCount;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Integer getForksCount() {
		return forksCount;
	}

	public void setForksCount(Integer forksCount) {
		this.forksCount = forksCount;
	}
}
