package com.arash.githubresume.service;

public interface GithubAPIService {

	public <T> T queryUsersData(String githubAccount);
	public <T> T queryReposData(String githubAccount);
}
