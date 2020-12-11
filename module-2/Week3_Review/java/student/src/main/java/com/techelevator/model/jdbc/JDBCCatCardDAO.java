package com.techelevator.model.jdbc;

import com.techelevator.model.CatCard;
import com.techelevator.model.CatCardDAO;
import com.techelevator.model.CatCardNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


public class JDBCCatCardDAO implements CatCardDAO {

	private JdbcTemplate jdbcTemplate;
	private Logger log = LoggerFactory.getLogger(getClass());

	public JDBCCatCardDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<CatCard> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CatCard get(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean save(CatCard cardToSave) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(long id, CatCard card) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(long id) {
		// TODO Auto-generated method stub
		return false;
	}








}
