package com.arash.githubresume;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;


@Controller
public class ResumeController2_del {
//
//    @GetMapping("/show")
//    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
//        model.addAttribute("name", name);
//        return "resume";
//    }
//    
//    @ModelAttribute("allSeedStarters0")
//    public List<Quote> populateSeedStarters0() {
//    	ArrayList<Quote> list = new ArrayList<>();
//    	Quote q1=new Quote();
//    	Value v1=new Value();
//    	v1.setId((long) 1);
//    	v1.setQuote("teetsdf tsdfsdf");
//    	q1.setType("t1");
//    	list.add(q1); 	
//    	
//    	Quote q12=new Quote();
//    	Value v12=new Value();
//    	v12.setId((long) 1);
//    	v12.setQuote("teetsdf tsdf12e1aqsdf");
//    	q12.setType("t12");
//    	list.add(q12);
//    	return list;
//
//    }    
//    
//    @ModelAttribute("allQuotes")
//    public List<Quote> populateSeedStarters() {
//    	ArrayList<Quote> list = new ArrayList<>();
//    	RestTemplate restTemplate = new RestTemplate();
//		
//		list.add(restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", Quote.class));
//		list.add(restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", Quote.class));
//		list.add(restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", Quote.class));
//		
//    	return list;
//
//    } 
//
//    
//    
//    @ModelAttribute("allSeedStarters1")
//    public List<String> populateSeedStarters1() {
//    	ArrayList<String> list = new ArrayList<>();
//    	list.add("arash");
//    	list.add("ari");
//    	list.add("mary");
//    	return list;
//
//    }
	
//	@ModelAttribute("nodes")
//	public List<NodeDTO> populateNodes() {
//		RestTemplate restTemplate = new RestTemplate();
//		ResponseEntity<List<NodeDTO>> response = restTemplate.exchange("https://api.github.com/users/mxcl/starred",
//				HttpMethod.GET, null, new ParameterizedTypeReference<List<NodeDTO>>() {
//				});
//		List<NodeDTO> employees = response.getBody();
//		return employees;
//	}
//
//	@ModelAttribute("repos")
//	public List<RepoDTO> populateRepos() {
//		RestTemplate restTemplate = new RestTemplate();
//		ResponseEntity<List<RepoDTO>> response = restTemplate.exchange("https://api.github.com/users/Frizlab/repos",
//				HttpMethod.GET, null, new ParameterizedTypeReference<List<RepoDTO>>() {
//				});
//		return response.getBody();
//	}
//
//	@ModelAttribute("user")
//	public UserDTO populateUserinfo() {
//		String urlAPI = (new StringBuilder(githubAPIBaseUrl)).append(githubAccount).toString();
//		LOG.info("Querying API: {}", urlAPI);
//		RestTemplate restTemplate = new RestTemplate();
//		ResponseEntity<UserDTO> response = restTemplate.exchange(urlAPI, HttpMethod.GET, null,
//				new ParameterizedTypeReference<UserDTO>() {
//				});
//		return response.getBody();
//	}
}
