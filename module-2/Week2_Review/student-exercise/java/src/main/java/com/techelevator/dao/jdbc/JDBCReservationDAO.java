package com.techelevator.dao.jdbc;

import com.techelevator.dao.ReservationDAO;
import com.techelevator.model.Reservation;
import com.techelevator.model.Site;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JDBCReservationDAO implements ReservationDAO {

    private JdbcTemplate jdbcTemplate;

    public JDBCReservationDAO(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public int createReservation(int siteId, String name, LocalDate fromDate, LocalDate toDate) {
    	String sqlStatement = "INSERT INTO reservation (reservation_id, site_id, name, from_date, to_date)"
    			+ " VALUES (?, ?, ?, ?)";
    	long id = getNextReservationId();
    	jdbcTemplate.update(sqlStatement, id, siteId, name, fromDate, toDate);
        return (int) id;
    }
    
    private Long getNextReservationId() {
    	SqlRowSet nextIdResult = jdbcTemplate.queryForRowSet("SELECT (nextval('reservation_reservation_id_seq') AS nextId");
    	if (nextIdResult.next()) {
    		return nextIdResult.getLong("nextId"); // 1 is the column from psql
    	}
    	throw new RuntimeException("Error getting reservation id");
    }

    private Reservation mapRowToReservation(SqlRowSet results) {
        Reservation r = new Reservation();
        r.setReservationId(results.getInt("reservation_id"));
        r.setSiteId(results.getInt("site_id"));
        r.setName(results.getString("name"));
        r.setFromDate(results.getDate("from_date").toLocalDate());
        r.setToDate(results.getDate("to_date").toLocalDate());
        r.setCreateDate(results.getDate("create_date").toLocalDate());
        return r;
    }


}
