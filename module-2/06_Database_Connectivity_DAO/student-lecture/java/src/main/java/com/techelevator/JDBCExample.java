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

		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/dvdstore");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");
		
		Connection conn = dataSource.getConnection(); // we've created the connection to DB
		
		/* Create a Statement object so that we can execute a SQL Query */
		
		Statement stmt = conn.createStatement(); // setup in order to be able to send a SQL query
		
		/* Execute a SQL query and return the results */
		String sqlActionFilmsReleaseIn2006 = "SELECT film.title, film.release_year "+
											 "FROM film JOIN film_category ON film.film_id = film_category.film_id "+
											 "JOIN category ON category.category_id = film_category.category_id "+
											 "WHERE film.release_year = 2006 "+
											 "AND category.name = 'Action'";
		
		ResultSet results = stmt.executeQuery(sqlActionFilmsReleaseIn2006); // query is actually sent to DB and performed
				//results can hold multiple rows of data from DB
		System.out.println("Film Title \t\t\tRelease Year");
		
		/* Iterate over the results and display each one */
		
		while(results.next()) {
			// results.getString returns the value from the column specified
	
			 // returns the value of the "title" column from the current row
			 // returns the value of the "release_year" column from the current row
			
			String title = results.getString("title"); // in the quote, give the column name from DB
			int releaseYear = results.getInt("release_year"); // the other column name, exactly how it is in the DB
			System.out.println(String.format("%-35s", title) + releaseYear);
		}
			
		
		/* The next query example takes a parameter (i.e. is dynamic) */
		String firstName = "Nick";
		String lastName = "Stallone";
		//String lastName = "O'Malley";     // This is an exmample of non-malicious user input that will cause the query to break
		String sqlMoviesByActor = "SELECT film.title "+
								  "FROM film join film_actor on film.film_id = film_actor.film_id "+
								  "JOIN actor on actor.actor_id = film_actor.actor_id "+
								  "WHERE actor.first_name = '"+firstName.toUpperCase()+"' "+
								  "AND actor.last_name = '"+lastName.toUpperCase()+"'";
		
		results = stmt.executeQuery(sqlMoviesByActor);
		System.out.println("\n\nFilms starring " + firstName + " " + lastName + ": ");
		while(results.next()) {
			String title = results.getString("title");
			System.out.println(title);
		}

		/* The solution to the problem of building dynamic SQL statements is to use a PreparedStatement */
		
		/* a parameterized SQL statement uses the '?' character as a placeholder for dynamic parameters */
		// to avoid SQL  injection
		String sqlMoviesByActorParameterized = "SELECT film.title "+
				  "FROM film join film_actor on film.film_id = film_actor.film_id "+
				  "JOIN actor on actor.actor_id = film_actor.actor_id "+
				  "WHERE actor.first_name = ? "+
				  "AND actor.last_name = ?";
		
	
		/* PreparedStatement objects are created using the Connection object */
		PreparedStatement moviesByActorStmt = conn.prepareStatement(sqlMoviesByActorParameterized);
		moviesByActorStmt.setString(1,  "NICK"); // replace first ? with Nick
		moviesByActorStmt.setString(2, "STALLONE"); // replace second ? with Stallone
		
		/* Call executeQuery to return the results as a ResultSet */
		results = moviesByActorStmt.executeQuery();
		
		System.out.println("\n\nFilms starring " + firstName + " " + lastName + ": ");
		while(results.next()) {
			String title = results.getString("title");
			System.out.println(title);
		}

		/* The statement objects can also be used to perform INSERT and UPDATE commands */

		PreparedStatement insertActorStmt = conn.prepareStatement("INSERT INTO actor(first_name, last_name) " +
																	"VALUES (?, ?)");
		
		String actorFirstName = "Bob";
		String actorLastName = "Smith";
		
		insertActorStmt.setString(1, actorFirstName);
		insertActorStmt.setString(2,  actorLastName);
	
		/* The execute method is used for INSERT and UPDATE statements */
		insertActorStmt.executeUpdate(); // should be executeUpdate
		
		PreparedStatement findActorByNameStmt = conn.prepareStatement("SELECT * FROM actor WHERE first_name = ? AND last_name = ?");
		findActorByNameStmt.setString(1, actorFirstName);
		findActorByNameStmt.setString(2, actorLastName);
		
		results = findActorByNameStmt.executeQuery();
		
		while(results.next()) {
			int id = results.getInt("actor_id");
			String fName = results.getString("first_name");
			String lName = results.getString("last_name");
			System.out.println(id + ") " + fName + " " + lName);
			}
		
		/* To use transactions in JDBC, we can turn off the default "autocommit" behavior of the Connection object */
		conn.setAutoCommit(false); // won't auto commit your statements
		
		PreparedStatement deleteBobSmithStmt = conn.prepareStatement("DELETE FROM actor WHERE first_name = 'Bob' AND last_name = 'Smith'");
		
		deleteBobSmithStmt.executeUpdate();
		
		/* Bob Smith rises again! */

	}
}
