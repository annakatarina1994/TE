package com.techelevator.shelter.controller;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.shelter.dao.PuppyDao;
import com.techelevator.shelter.dao.ShelterDao;
import com.techelevator.shelter.model.Puppy;
import com.techelevator.shelter.model.Shelter;

@RestController
@PreAuthorize("isAuthenticated()")
public class ShelterController {

	private ShelterDao shelterDao;
	private PuppyDao puppyDao;
	
	public ShelterController(ShelterDao shelterDao, PuppyDao puppyDao) {
		this.shelterDao = shelterDao;
		this.puppyDao = puppyDao;
	}
	
	@RequestMapping(path = "shelter", method = RequestMethod.GET)
	public List<Shelter> listShelters(){
		return shelterDao.list();
	}
	
	@RequestMapping(path = "shelter", method = RequestMethod.POST)
	public void createShelter(@RequestBody Shelter newShelter) {
		shelterDao.create(newShelter);
	}
	
	@RequestMapping(path = "shelter/{id}", method = RequestMethod.GET)
	public Shelter listShelterById(@PathVariable int id) {
		return shelterDao.get(id);
	}
	
	@RequestMapping(path = "puppies", method = RequestMethod.GET)
	public List<Puppy> listPuppies(){
		return puppyDao.findAll();
	}

}
