package com.arash.githubresume;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RepoDTO {
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("url")
	private String url;

	@JsonProperty("description")
	private String description;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


}
