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
		BASE_URL = url;
		restTemplate = new RestTemplate();		
	}
	
	public Shelter[] getAllShelters(String authToken) {
		HttpHeaders headers = new HttpHeaders();
		headers.setBearerAuth(authToken);
		HttpEntity entity = new HttpEntity(headers);
		ResponseEntity <Shelter []> response = 
				restTemplate.exchange(BASE_URL + "shelter", HttpMethod.GET,
						entity, Shelter[].class);
		
		return response.getBody();
		
	}

}
