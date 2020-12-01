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

		
		/* The JdbcTemplate is the main interface we use to interact with databases using
		 * Spring JDBC. */
	
		
		
		/* The JdbcTemplate can be used to execute parameterized SQL statements */
		String sqlFilmsByCategory =  "SELECT film.title, film.release_year "+
									 "FROM film JOIN film_category ON film.film_id = film_category.film_id "+
									 "JOIN category ON category.category_id = film_category.category_id "+
									 "WHERE category.name = ?";
		
		/* The first parameter to the "queryForRowSet" method is a String containing a parameterized SQL statement
		 * Any following parameters are used to replace query placeholders (i.e. '?') in the order in which they appear */
		String category = "Comedy";
		
		
		/* use the "update" method to run INSERT, UPDATE, and DELETE statements */
		String sqlCreateActor = "INSERT INTO actor(actor_id, first_name, last_name) "+
								"VALUES (?, ?, ?)";
		
		
		
		/* The next example makes use of the world database, so we need a new 
		 * DataSource for creating connections to that database. */
	
		
		/* The JdbcTemplate is the main interface we use to interact with databases using
		 * Spring JDBC. */
	
		
		/*
		 * Sequences are often used to generate a unique Id value prior to inserting
		 * a new record.
		 */
		String sqlGetNextId = "SELECT nextval('seq_city_id')";
	
		
		/*
		 * Now create a new city record using the generated id 
		 */

	}
}
