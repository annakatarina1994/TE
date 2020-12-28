package com.techelevator.shelter.dao.jdbc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.shelter.dao.PuppyDao;
import com.techelevator.shelter.model.Puppy;

@Component
public class JdbcPuppyDao implements PuppyDao {
	
	JdbcTemplate jdbcTemplate;

	@Override
	public List<Puppy> findAll() {
		List<Puppy> puppyList = new ArrayList<>();
		String sqlListPups = "SELECT * FROM puppy";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlListPups);
		while(results.next()) {
			Puppy puppy = mapRowToPuppy(results);
			puppyList.add(puppy);
		}
		
		return puppyList;
	}

	@Override
	public List<Puppy> findByShelter(int shelterId) {
		List<Puppy> puppyListByShelter = new ArrayList<>();
		String sqlPupsByShelter = "SELECT * FROM puppy WHERE shelter_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlPupsByShelter, shelterId);
		while(results.next()) {
			Puppy puppy = mapRowToPuppy(results);
			puppyListByShelter.add(puppy);
		}
		return puppyListByShelter;
	}

	@Override
	public Puppy get(int puppyId) {
		Puppy puppy = new Puppy();
		String sqlGetById = "SELECT * FROM puppy WHERE puppy_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetById, puppyId);
		if(results.next()) {
			puppy = mapRowToPuppy(results);
		}
		return puppy;
	}

	
	@Override
	public Puppy addPuppy(Puppy puppy, int shelterId) {
		String sqlAddPuppy = "INSERT INTO puppy(puppy_name, puppy_breed, puppy_age, puppy_gender, shelter_id) "
				+ " VALUES (?, ?, ?, ?, ?)";
		jdbcTemplate.update(sqlAddPuppy, shelterId, puppy.getName(), puppy.getBreed(), puppy.getAge(), 
				puppy.getGender(), puppy.getShelterId());
		return puppy;
	}

	@Override
	public Puppy updatePuppy(Puppy puppy, int puppyId) {
		return null;
	}

	@Override
	public void adopt(int puppyId) {
		// TODO Auto-generated method stub

	}
	
	// helper methods
	
	private Puppy mapRowToPuppy(SqlRowSet results) {
		Puppy puppy = new Puppy();
		puppy.setId(results.getInt("puppy_id"));
		puppy.setName(results.getString("puppy_name"));
		puppy.setBreed(results.getString("puppy_breed"));
		puppy.setAge(results.getInt("puppy_age"));
		puppy.setGender(results.getString("puppy_gender"));
		puppy.setShelterId(results.getInt("shelter_id"));
		return puppy;
	}

}
