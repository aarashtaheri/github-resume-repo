package com.arash.githubresume.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
public class ResumeController {

	private static final String REPOS = "repos";
	private static final String SLASH = "/";
	private final String GITHUB_USERS_API = "https://api.github.com/users";

	private static final Logger LOG = LoggerFactory.getLogger(ResumeController.class);

	@GetMapping("/show")
	public String greeting(@RequestParam(value = "githubAccount", required = true) String githubAccount, Model model) {
		model.addAttribute("githubAccount", githubAccount);
		
		String userAPI = (new StringBuilder(GITHUB_USERS_API)).append(SLASH).append(githubAccount).toString();
		model.addAttribute("user", queryAPI(userAPI));
		

		String reposAPI = (new StringBuilder(userAPI)).append(SLASH).append(REPOS).toString();
		model.addAttribute(REPOS, queryAPI(reposAPI));

		return "resume";
	}

	private <T> T queryAPI(String url) {
		LOG.info("Querying API: {}", url);
	
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<T> response = restTemplate.exchange(url, HttpMethod.GET, null,
				new ParameterizedTypeReference<T>() {
				});
		return response.getBody();
	}
}
