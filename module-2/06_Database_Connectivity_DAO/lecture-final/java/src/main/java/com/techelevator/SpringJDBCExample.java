package com.techelevator;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

/* Working with JDBC entails a lot of boilerplate code which can become 
 * tedious and error prone. The Spring JBDC framework can help eliminate 
 * much of the boilerplate code, and limit the tedium and mistakes. */
public class SpringJDBCExample {

	public static void main(String[] args) {
		
		/* This datasource will be used for creating connections to the database.
		 * Below, we provide the information required to make database connections */

		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/dvdstore");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");
		
		/* The JdbcTemplate is the main interface we use to interact with databases using
		 * Spring JDBC. */
	
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		
		/* The JdbcTemplate can be used to execute parameterized SQL statements */
		String sqlFilmsByCategory =  "SELECT film.title, film.release_year "+
									 "FROM film JOIN film_category ON film.film_id = film_category.film_id "+
									 "JOIN category ON category.category_id = film_category.category_id "+
									 "WHERE category.name = ?";
		
		/* The first parameter to the "queryForRowSet" method is a String containing a parameterized SQL statement
		 * Any following parameters are used to replace query placeholders (i.e. '?') in the order in which they appear */
		String category = "Comedy";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFilmsByCategory, category);
		
		System.out.println(category + " Films: ");
		while (results.next()) {
			String filmTitle = results.getString("title");
			int releaseYear = results.getInt("release_year");
			
			System.out.println(filmTitle + " (" + releaseYear + ")");
		}
		
		
		/* use the "update" method to run INSERT, UPDATE, and DELETE statements */
		String sqlCreateActor = "INSERT INTO actor(actor_id, first_name, last_name) "+
								"VALUES (?, ?, ?)";  // we would usually not pass in the actor_id and just let postgres assign it.
		
		
//		jdbcTemplate.update(sqlCreateActor, 1000, "Minnie", "Mouse");  -- comment out so we don't throw the DuplicateKeyException
		
		/* The next example makes use of the world database, so we need a new 
		 * DataSource for creating connections to that database. */
		
		BasicDataSource worldDataSource = new BasicDataSource();
		worldDataSource.setUrl("jdbc:postgresql://localhost:5432/world");
		worldDataSource.setUsername("postgres");
		worldDataSource.setPassword("postgres1");
		
		
		
		/* The JdbcTemplate is the main interface we use to interact with databases using
		 * Spring JDBC. */
		JdbcTemplate worldJdbcTemplate = new JdbcTemplate(worldDataSource);
		
		/*
		 * Sequences are often used to generate a unique Id value prior to inserting
		 * a new record.
		 */
		String sqlGetNextId = "SELECT nextval('seq_city_id')";  // not only returns the next city_id but also advances the id
		results = worldJdbcTemplate.queryForRowSet(sqlGetNextId);  // will return the next city_id from postgres world database
		results.next();  // advances to the first row
		int id = results.getInt(1); // returns the integer value of the first column)
		
		System.out.println("\n\nNew City id: " + id);
	
		
		/*
		 * Now create a new city record using the generated id 
		 */
		String sqlCreateNewCity = "INSERT INTO city (id, name, countrycode, district, population) " +
		           "VALUES (?, ?, ?, ?, ?)";

		
		worldJdbcTemplate.update(sqlCreateNewCity, id, "MouseCity", "USA", "Kansas", 45001);
	}
}
