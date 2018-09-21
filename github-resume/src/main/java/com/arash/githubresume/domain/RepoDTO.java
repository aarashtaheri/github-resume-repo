package com.arash.githubresume.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RepoDTO {
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("url")
	private String url;

	@JsonProperty("description")
	private String description;
	
	@JsonProperty("size")
	private Integer size;

	/**
	 * indicates the percent size of this Repository compared to the whole Repositories
	 */
	@JsonIgnore
	private double percentSize;

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

	public double getPercentSize() {
		return percentSize;
	}

	public void setPercentSize(double percentSize) {
		this.percentSize = percentSize;
	}
	
	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}


}
