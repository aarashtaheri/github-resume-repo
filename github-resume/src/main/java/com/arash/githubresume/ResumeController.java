package com.arash.githubresume;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;


@Controller
public class ResumeController {

    @GetMapping("/show")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "resume";
    }
    
    @ModelAttribute("nodes")
    public List<NodeDTO> populateNodes() {
    	RestTemplate restTemplate = new RestTemplate();
    	ResponseEntity<List<NodeDTO>> response = restTemplate.exchange(
    	  "https://api.github.com/users/mxcl/starred",
    	  HttpMethod.GET,
    	  null,
    	  new ParameterizedTypeReference<List<NodeDTO>>(){});
    	List<NodeDTO> employees = response.getBody();
    	return employees;
    } 
    
    @ModelAttribute("repos")
    public List<RepoDTO> populateRepos() {
    	RestTemplate restTemplate = new RestTemplate();
    	ResponseEntity<List<RepoDTO>> response = restTemplate.exchange(
    	  "https://api.github.com/users/Frizlab/repos",
    	  HttpMethod.GET,
    	  null,
    	  new ParameterizedTypeReference<List<RepoDTO>>(){});
    	return response.getBody();
    }   
    
 
    @ModelAttribute("user")
    public UserDTO populateUserinfo() {
    	RestTemplate restTemplate = new RestTemplate();
    	ResponseEntity<UserDTO> response = restTemplate.exchange(
    	  "https://api.github.com/users/aarashtaheri",
    	  HttpMethod.GET,
    	  null,
    	  new ParameterizedTypeReference<UserDTO>(){});
    	return response.getBody();
    }   
    
    @ModelAttribute("allQuotes")
    public List<Quote> allQuotes() {
    	ArrayList<Quote> list = new ArrayList<>();
    	RestTemplate restTemplate = new RestTemplate();
		
		list.add(restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", Quote.class));
		list.add(restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", Quote.class));
		list.add(restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", Quote.class));
		
    	return list;
    }
}
