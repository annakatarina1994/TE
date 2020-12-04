package com.techelevator.projects.model.jdbc;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import com.techelevator.projects.model.Department;
import com.techelevator.projects.model.DepartmentDAO;



public class JDBCDepartmentDAOTest {
	
	
	private static SingleConnectionDataSource dataSource;
	private DepartmentDAO dao;  // interface allows me to set up other classes 
	
	@BeforeClass  // runs only once at the beginning of running this class (file)
	public static void setupDataSource() {
		dataSource = new SingleConnectionDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/projects");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");
		
		//disable autocommit for connections returned by this Datasource.
		// This will allow us to rollback any changes after each test
		dataSource.setAutoCommit(false);
	}

	
	/* After all tests have finished running, this method will close the DataSource */
	@AfterClass
	public static void closeDataSource() throws SQLException {
		dataSource.destroy();
	}


	@Before
	public void setup() {	
		dao = new JDBCDepartmentDAO(dataSource);

	}
	
	@After
	public void rollback() throws SQLException {
		dataSource.getConnection().rollback();
	}
	
	
	@Test
	public void test_create_department_has_correct_name() {
		String departmentName = "Finance";
				
		Department theDepartment = new Department();  // create a java object
		theDepartment.setName(departmentName);  //set the name on the java object

		Department savedDepartment = dao.createDepartment(theDepartment);
		
		
		assertEquals(departmentName, savedDepartment.getName());
	}

}
