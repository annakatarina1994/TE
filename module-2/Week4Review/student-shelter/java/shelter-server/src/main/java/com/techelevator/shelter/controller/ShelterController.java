package com.techelevator.shelter.controller;

import org.springframework.web.bind.annotation.RestController;

import com.techelevator.shelter.dao.PuppyDao;
import com.techelevator.shelter.dao.ShelterDao;

@RestController
public class ShelterController {

	private ShelterDao shelterDao;
	private PuppyDao puppyDao;
	
	public ShelterController(ShelterDao shelterDao, PuppyDao puppyDao) {
		this.shelterDao = shelterDao;
		this.puppyDao = puppyDao;
	}
	
	

}
