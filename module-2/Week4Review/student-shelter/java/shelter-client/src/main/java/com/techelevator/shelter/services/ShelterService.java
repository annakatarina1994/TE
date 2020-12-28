package com.techelevator.shelter.services;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.techelevator.shelter.models.Shelter;

public class ShelterService {
	
	private String BASE_URL;
	private RestTemplate restTemplate;
	
	public ShelterService(String url) {
		this.BASE_URL = url;
		this.restTemplate = new RestTemplate();
	}
	
	// list all shelters
	
	public Shelter[] getAllShelters(String authToken) {
		HttpHeaders headers = new HttpHeaders();
		headers.setBearerAuth(authToken);
		HttpEntity<Shelter> entity = new HttpEntity<>(headers);
		ResponseEntity <Shelter []> response = restTemplate.exchange(BASE_URL + "shelter", HttpMethod.GET, 
				entity, Shelter[].class);
		return response.getBody();
	}
	
	// list all pups
	
	

	// helper methods
//	private HttpEntity makeAuthEntity() {
//		HttpHeaders headers = new HttpHeaders();
//    	headers.setBearerAuth(AUTH_TOKEN);
//    	HttpEntity entity = new HttpEntity<>(headers);
//   	 return entity;
//	}
	
}
