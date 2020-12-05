package com.techelevator.dao.jdbc;

import com.techelevator.dao.ParkDAO;
import com.techelevator.model.Park;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JDBCParkDAO implements ParkDAO {

    private JdbcTemplate jdbcTemplate;

    public JDBCParkDAO(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
  // DO WE WANT this CLASS TO DO CRUD???
    
    
    @Override
    public List<Park> getAllParks() {
    	List<Park> parks = new ArrayList<Park>();
    	String sqlSearchForParks = "SELECT * FROM park ORDER BY location";
    	
    	SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSearchForParks);
    	
    	while (results.next()) {
    		Park thePark = mapRowToPark(results);
    		parks.add(thePark);
    	}
    	
        return parks;
    }

    private Park mapRowToPark(SqlRowSet results) {
        Park park = new Park();
        park.setParkId(results.getInt("park_id"));
        park.setName(results.getString("name"));
        park.setLocation(results.getString("location"));
        park.setEstablishDate(results.getDate("establish_date").toLocalDate());
        park.setArea(results.getInt("area"));
        park.setVisitors(results.getInt("visitors"));
        park.setDescription(results.getString("description"));
        return park;
    }


	@Override
	public Park createNewPark(Park park) {
		String sqlCreateNewPark = "INSERT INTO park (name, location, establish_date," +
					" area, visitors, description) VALUES (?, ?, ?, ?, ?, ?) RETURNING park_id";
		
		Object[] obj = new Object[] { park.getName(),
				park.getLocation(), park.getEstablishDate(), park.getArea(), park.getVisitors(),
				park.getDescription()};
		
		Integer id = jdbcTemplate.queryForObject(sqlCreateNewPark, obj, Integer.class);
		
		park.setParkId(id);

		return park;
	}


	@Override
	public void deleteParkById(int parkId) {
		String sqlDeleteParkById = "DELETE FROM park WHERE park_id = ?";
		
		jdbcTemplate.update(sqlDeleteParkById, parkId);
		
		
	}
	


}
