package com.techelevator.projects.view;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import com.techelevator.projects.model.Department;
import com.techelevator.projects.model.jdbc.JDBCDepartmentDAO;

public class JDBCDepartmentDAOTest {
	
	private static final String TEST_DEPARTMENT = "Testing";
	private static final Long TEST_ID = (long)99;
	private static SingleConnectionDataSource dataSource;
	private JDBCDepartmentDAO deptDao;
	
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
		deptDao = new JDBCDepartmentDAO(dataSource);
	}
	
	@After
	public void rollback() throws SQLException {
		dataSource.getConnection().rollback();
	}
	
	
	@Test
	public void createDepartment_creates_new_department() {
		List<Department> departments = deptDao.getAllDepartments();
		int sizeBeforeCreate = departments.size();
		
		Department dept = getDepartment((long) 1, TEST_DEPARTMENT);
		deptDao.createDepartment(dept);
		
		List<Department> deptsAfterCreate = deptDao.getAllDepartments();
		int sizeAfterCreate = deptsAfterCreate.size();
		
		assertEquals(sizeBeforeCreate + 1, sizeAfterCreate);
		
	}

	
	@Test
	public void searchDeptByName_returns_by_name() {
		Department dept = getDepartment((long) 1, "Testing");
		deptDao.createDepartment(dept);
		
		List<Department> results = deptDao.searchDepartmentsByName("Testing");
		
		assertNotNull(results);
		assertEquals(1, results.size());
		Department savedDept = results.get(0);
		assertDeptsAreEqual(dept, savedDept);
	}
	
	
// not sure if there's something wrong with my test or my method...
	@Test
	public void getDepartmentByID_returns_department_according_to_ID() {
		Department dept = getDepartment(TEST_ID, "Testing");
		
		deptDao.createDepartment(dept);
//		List<Department> departments = dao.getAllDepartments();
		
		Department result = deptDao.getDepartmentById(dept.getId());
		
		assertNotNull(result);
		assertDeptsAreEqual(dept, result);
	}
	
	//helper methods
	private Department getDepartment(Long departmentId, String departmentName) {
		Department dept = new Department();
		dept.setId(departmentId);
		dept.setName(departmentName);
		return dept;
	}
	
	private void assertDeptsAreEqual(Department expected, Department actual) {
		assertEquals(expected.getId(), actual.getId());
		assertEquals(expected.getName(), actual.getName());
	}

}
