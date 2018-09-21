package com.arash.githubresume.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.arash.githubresume.controller.ResumeController;
import com.arash.githubresume.domain.RepoDTO;
import com.arash.githubresume.domain.UserDTO;

@Service
public class GithubAPIServiceImpl implements GithubAPIService {

	private final String GITHUB_USERS_API = "https://api.github.com/users";
	private static final String REPOS = "repos";
	private static final String SLASH = "/";

	private static final Logger LOG = LoggerFactory.getLogger(ResumeController.class);

	private <T> T queryAPI(String url) {
		LOG.info("Querying API: {}", url);
					
		ResponseEntity<T> response;
		try {
			RestTemplate restTemplate = new RestTemplate();
			response = restTemplate.exchange(url, HttpMethod.GET, null,
					new ParameterizedTypeReference<T>() {
					});
		} catch (RestClientException e) {
			LOG.error("Error by querying the endpoint {}", url);
			throw e;
		}
				
		return response.getBody();
	}
	
	@Override
	public UserDTO queryUsersData(String githubAccount) {
		String userAPI = (new StringBuilder(GITHUB_USERS_API))
				.append(SLASH).append(githubAccount)
				.toString();
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<UserDTO> response  = restTemplate.getForEntity(userAPI, UserDTO.class);
		
		return response.getBody();
	}

	@Override
	public List<RepoDTO> queryReposData(String githubAccount) {
		String reposAPI = (new StringBuilder(GITHUB_USERS_API)).append(SLASH)
				.append(githubAccount).append(SLASH).append(REPOS)
				.toString();
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<List<RepoDTO>> response = restTemplate.exchange(reposAPI, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<RepoDTO>>() {
				});

		List<RepoDTO> repos = response.getBody();
		repos = calculatePercentSize(repos);
		
		return repos;
	}

	private List<RepoDTO> calculatePercentSize(List<RepoDTO> repos) {
		int sum = repos.stream().mapToInt(r -> r.getSize()).sum();
		repos.stream().forEach(r -> r.setPercentSize(100.0 * r.getSize()/sum));
		return repos;
	}

}
