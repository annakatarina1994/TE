package com.techelevator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.dbcp2.BasicDataSource;

public class JDBCExample {

	public static void main(String[] args) throws SQLException {
		
		/* This datasource will be used for creating connections to the database.
		 * Below, we provide the information required to make database connections */

		
		
		/* Create a Statement object so that we can execute a SQL Query */

		
		/* Execute a SQL query and return the results */
		String sqlActionFilmsReleaseIn2006 = "SELECT film.title, film.release_year "+
											 "FROM film JOIN film_category ON film.film_id = film_category.film_id "+
											 "JOIN category ON category.category_id = film_category.category_id "+
											 "WHERE film.release_year = 2006 "+
											 "AND category.name = 'Action'";
		

		
		/* Iterate over the results and display each one */
	
			 // returns the value of the "title" column from the current row
			 // returns the value of the "release_year" column from the current row
			
		
		
		
		/* The next query example takes a parameter (i.e. is dynamic) */
		String firstName = "Nick";
		String lastName = "Stallone";
		//String lastName = "O'Malley";     // This is an exmample of non-malicious user input that will cause the query to break
		String sqlMoviesByActor = "SELECT film.title "+
								  "FROM film join film_actor on film.film_id = film_actor.film_id "+
								  "JOIN actor on actor.actor_id = film_actor.actor_id "+
								  "WHERE actor.first_name = '"+firstName.toUpperCase()+"' "+
								  "AND actor.last_name = '"+lastName.toUpperCase()+"'";
		

		/* The solution to the problem of building dynamic SQL statements is to use a PreparedStatement */
		
		/* a parameterized SQL statement uses the '?' character as a placeholder for dynamic parameters */
		String sqlMoviesByActorParameterized = "SELECT film.title "+
				  "FROM film join film_actor on film.film_id = film_actor.film_id "+
				  "JOIN actor on actor.actor_id = film_actor.actor_id "+
				  "WHERE actor.first_name = ? "+
				  "AND actor.last_name = ?";
		
		/* PreparedStatement objects are created using the Connection object */

		/* Call executeQuery to return the results as a ResultSet */

		/* The statment objects can also be used to perform INSERT and UPDATE commands */

	
		/* The execute method is used for INSERT and UPDATE statements */

		
		/* To use transactions in JDBC, we can turn off the default "autocommit" behavior of the Connection object */

		
		/* Marc O'Malley rises again! */

	}
}
