package com.techelevator.projects.view;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.time.LocalDate;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import com.techelevator.projects.model.Project;
import com.techelevator.projects.model.jdbc.JDBCProjectDAO;

public class JDBCProjectDAOTest {

	private static SingleConnectionDataSource dataSource;
	private JDBCProjectDAO projectDao;
	
	@BeforeClass
	public static void setupDataSource() {
		dataSource = new SingleConnectionDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/projects");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");
		
		dataSource.setAutoCommit(false);
	}
	
	@AfterClass
	public static void closeDataSource() throws SQLException{
		dataSource.destroy();
	}
	
	@Before
	public void setup() {
		projectDao = new JDBCProjectDAO(dataSource);
	}
	
	@After
	public void rollback() throws SQLException {
		dataSource.getConnection().rollback();
	}
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	// helper methods
	
	private Project getProject(Long projectId, String name, LocalDate startDate, LocalDate endDate) {
		Project project = new Project();
		project.setId(projectId);
		project.setName(name);
		project.setStartDate(startDate);
		project.setEndDate(endDate);
		return project;
	}

	private void assertProjectsAreEqual(Project expected, Project actual) {
		assertEquals(expected.getId(), actual.getId());
		assertEquals(expected.getName(), actual.getName());
		assertEquals(expected.getStartDate(), actual.getEndDate());
		assertEquals(expected.getEndDate(), actual.getEndDate());
	}
}
