package com.arash.githubresume.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.arash.githubresume.controller.ResumeController;

@Service
public class GithubAPIServiceImpl implements GithubAPIService {

	private static final String REPOS = "repos";
	private static final String SLASH = "/";
	private final String GITHUB_USERS_API = "https://api.github.com/users";

	private static final Logger LOG = LoggerFactory.getLogger(ResumeController.class);

	private <T> T queryAPI(String url) {
		LOG.info("Querying API: {}", url);
	
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<T> response = restTemplate.exchange(url, HttpMethod.GET, null,
				new ParameterizedTypeReference<T>() {
				});
		return response.getBody();
	}

	@Override
	public <T> T queryUsersData(String githubAccount) {
		String userAPI = (new StringBuilder(GITHUB_USERS_API))
				.append(SLASH).append(githubAccount)
				.toString();
		return queryAPI(userAPI);
	}

	@Override
	public <T> T queryReposData(String githubAccount) {
		String reposAPI = (new StringBuilder(GITHUB_USERS_API)).append(SLASH)
				.append(githubAccount).append(SLASH).append(REPOS)
				.toString();
		return queryAPI(reposAPI);
	}

}
