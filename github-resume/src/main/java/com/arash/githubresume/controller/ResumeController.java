package com.arash.githubresume.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.arash.githubresume.service.GithubAPIService2;

@Controller
public class ResumeController {

	private static final Logger LOG = LoggerFactory.getLogger(ResumeController.class);

	@Autowired
	GithubAPIService2 queryGithubAPIService;

	@GetMapping("/show")
	public String greeting(@RequestParam(value = "githubAccount", required = true) String githubAccount, Model model) {
		model.addAttribute("user", queryGithubAPIService.queryUsersData(githubAccount));
		model.addAttribute("repos", queryGithubAPIService.queryReposData(githubAccount));
		return "resume";
	}

}
