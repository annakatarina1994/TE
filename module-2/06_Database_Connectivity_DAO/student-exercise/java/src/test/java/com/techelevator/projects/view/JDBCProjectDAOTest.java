package com.techelevator.projects.view;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import com.techelevator.projects.model.Project;
import com.techelevator.projects.model.ProjectDAO;
import com.techelevator.projects.model.jdbc.JDBCProjectDAO;

public class JDBCProjectDAOTest {

	private static SingleConnectionDataSource dataSource;
	private ProjectDAO projectDao;
	
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
	public void getAllActiveProjects_only_returns_active_projects() {
		List<Project> projects = projectDao.getAllActiveProjects();
		int sizeBeforeCreate = projects.size();
		
		Project project = getProject((long)45, "Test Project", LocalDate.of(2020, 1, 1), LocalDate.of(2022, 12, 12));
		projectDao.createProject(project);
		
		List<Project> resultsAfterCreate = projectDao.getAllActiveProjects();
		int sizeAfterCreate = resultsAfterCreate.size();
		
		assertEquals(sizeBeforeCreate + 1, sizeAfterCreate);
	}
	
	@Test
	public void createProject_should_add_new_project() {
		List<Project> projects = projectDao.getAllProjects();
		int sizeBeforeCreate = projects.size();
		
		Project project = getProject((long)33, "Test Project", LocalDate.of(2020, 1, 1), LocalDate.of(2020, 12, 21));
		projectDao.createProject(project);
		
		List<Project> projectsAfterCreate = projectDao.getAllProjects();
		int sizeAfterCreate = projectsAfterCreate.size();
		
		assertEquals(sizeBeforeCreate + 1, sizeAfterCreate);
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
		assertEquals(expected.getStartDate(), actual.getStartDate());
		assertEquals(expected.getEndDate(), actual.getEndDate());
	}
}
 