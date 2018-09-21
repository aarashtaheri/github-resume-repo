package com.arash.githubresume.service;

import java.util.List;

import com.arash.githubresume.domain.RepoDTO;
import com.arash.githubresume.domain.UserDTO;

public interface GithubAPIService {

	public UserDTO queryUsersData(String githubAccount);
	public List<RepoDTO> queryReposData(String githubAccount);
}
