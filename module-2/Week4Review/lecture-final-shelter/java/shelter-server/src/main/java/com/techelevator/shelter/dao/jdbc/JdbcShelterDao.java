package com.techelevator.shelter.dao.jdbc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.shelter.dao.ShelterDao;
import com.techelevator.shelter.model.Shelter;

@Component
public class JdbcShelterDao implements ShelterDao {
	
	JdbcTemplate jdbcTemplate;
	
	public JdbcShelterDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public List<Shelter> list() {
		List<Shelter> shelterList = new ArrayList<>();
		String sql = "SELECT * FROM shelter";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
		while (results.next()) {
			 Shelter theShelter = mapRowToShelter(results);
			 shelterList.add(theShelter);
		}
		
		return shelterList;
	}

	@Override
	public void create(Shelter shelter) {
		String sql = "INSERT INTO shelter (shelter_name, shelter_address, shelter_city, shelter_state, shelter_zip) " +
					"VALUES (?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql, shelter.getName(), shelter.getAddress(), shelter.getCity(), shelter.getState(), shelter.getZipcode());
		
	}

	@Override
	public Shelter get(int id) {
		Shelter shelter = new Shelter();
		String sql = "SELECT * FROM shelter WHERE shelter_id = ?";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
		if (results.next()) {
			shelter = mapRowToShelter(results);
		}
		
		return shelter;
	}

	private Shelter mapRowToShelter(SqlRowSet results) {
		Shelter theShelter = new Shelter();
		theShelter.setAddress(results.getString("shelter_address"));
		theShelter.setCity(results.getString("shelter_city"));
		theShelter.setId(results.getInt("shelter_id"));
		theShelter.setName(results.getString("shelter_name"));
		theShelter.setState(results.getString("shelter_state"));
		theShelter.setZipcode(results.getString("shelter_zip"));
		return theShelter;
	}
}
