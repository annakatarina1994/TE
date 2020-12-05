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

import com.techelevator.projects.model.Employee;
import com.techelevator.projects.model.jdbc.JDBCDepartmentDAO;

public class JDBCEmployeeDAOTest {

	private static SingleConnectionDataSource dataSource;
	private JDBCDepartmentDAO employeeDao;
	
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
		employeeDao = new JDBCDepartmentDAO(dataSource);
	}
	
	@After
	public void rollback() throws SQLException {
		dataSource.getConnection().rollback();
	}
	
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	//helper methods
	
	private Employee getEmployee(Long employeeId, Long departmentId, String firstName, String lastName, LocalDate birthDate, LocalDate hireDate, String gender) {
		Employee emp = new Employee();
		emp.setId(employeeId);
		emp.setDepartmentId(departmentId);
		emp.setFirstName(firstName);
		emp.setLastName(lastName);
		emp.setBirthDay(birthDate);
		emp.setHireDate(hireDate);
		emp.setGender(gender.charAt(0));
		return emp;
	}
	
	private void assertEmpsAreEqual(Employee expected, Employee actual) {
		assertEquals(expected.getId(), actual.getId());
		assertEquals(expected.getDepartmentId(), actual.getDepartmentId());
		assertEquals(expected.getFirstName(), actual.getFirstName());
		assertEquals(expected.getLastName(), actual.getLastName());
		assertEquals(expected.getBirthDay(), actual.getBirthDay());
		assertEquals(expected.getHireDate(), actual.getHireDate());
		assertEquals(expected.getGender(), actual.getGender());
	}

}
