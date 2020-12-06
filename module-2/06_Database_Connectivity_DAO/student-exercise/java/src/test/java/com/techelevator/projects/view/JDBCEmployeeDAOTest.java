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

import com.techelevator.projects.model.Employee;
import com.techelevator.projects.model.EmployeeDAO;
import com.techelevator.projects.model.jdbc.JDBCDepartmentDAO;
import com.techelevator.projects.model.jdbc.JDBCEmployeeDAO;

public class JDBCEmployeeDAOTest {

	private static SingleConnectionDataSource dataSource;
	private EmployeeDAO employeeDao;
	
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
		employeeDao = new JDBCEmployeeDAO(dataSource);
	}
	
	@After
	public void rollback() throws SQLException {
		dataSource.getConnection().rollback();
	}
	
	@Test
	public void getEmpsByDeptId_returns_only_employees_in_that_department() {
		Employee emp = getEmployee((long)99, (long)9, "Harriet", "Tester", LocalDate.of(1990,5,5), "F", LocalDate.of(2015,5,30));
		employeeDao.createEmployee(emp);
		
		List<Employee> results = employeeDao.getEmployeesByDepartmentId((long)9);
		
		assertNotNull(results);
		assertEquals(1, results.size());
		Employee savedEmp = results.get(0);
		assertEmpsAreEqual(emp, savedEmp);
	}
	
	
	@Test
	public void searchEmployeesByName_should_return_employee_by_name() {
		Employee emp = getEmployee((long)99, (long)9, "Selma", "Tester", LocalDate.of(1990,5,5), "F", LocalDate.of(2015,5,30));
		employeeDao.createEmployee(emp);
		
		List<Employee> results = employeeDao.searchEmployeesByName("Selma", "Tester");
		
		assertNotNull(results);
		assertEquals(1, results.size());
		Employee savedEmp = results.get(0);
		assertEmpsAreEqual(emp, savedEmp);
		
	}
	
	@Test
	public void getAllEmployees_should_return_all_employees() {
		List<Employee> employees = employeeDao.getAllEmployees();
		int sizeBeforeCreate = employees.size();
		
		Employee emp = getEmployee((long)99, (long)9, "Theodore", "Tester", LocalDate.of(1990,5,5), "F", LocalDate.of(2015,5,30));
		employeeDao.createEmployee(emp);
		
		List<Employee> employeesAfterCreate = employeeDao.getAllEmployees();
		int sizeAfterCreate = employeesAfterCreate.size();
		
		assertEquals(sizeBeforeCreate + 1, sizeAfterCreate);
	}
	
	
	
	//helper methods
	
	private Employee getEmployee(Long employeeId, Long departmentId, String firstName, String lastName, LocalDate birthDate, String gender, LocalDate hireDate) {
		Employee emp = new Employee();
		emp.setId(employeeId);
		emp.setDepartmentId(departmentId);
		emp.setFirstName(firstName);
		emp.setLastName(lastName);
		emp.setBirthDay(birthDate);
		emp.setGender(gender.charAt(0));
		emp.setHireDate(hireDate);
		return emp;
	}
	
	private void assertEmpsAreEqual(Employee expected, Employee actual) {
		assertEquals(expected.getId(), actual.getId());
		assertEquals(expected.getDepartmentId(), actual.getDepartmentId());
		assertEquals(expected.getFirstName(), actual.getFirstName());
		assertEquals(expected.getLastName(), actual.getLastName());
		assertEquals(expected.getBirthDay(), actual.getBirthDay());
		assertEquals(expected.getGender(), actual.getGender());
		assertEquals(expected.getHireDate(), actual.getHireDate());
	}
	


}
