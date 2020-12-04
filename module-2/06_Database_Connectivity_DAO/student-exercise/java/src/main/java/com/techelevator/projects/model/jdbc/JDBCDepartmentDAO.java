package com.techelevator.projects.model.jdbc;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.model.Department;
import com.techelevator.projects.model.DepartmentDAO;

public class JDBCDepartmentDAO implements DepartmentDAO {
	
	private JdbcTemplate jdbcTemplate;

	public JDBCDepartmentDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Department> getAllDepartments() {
		List<Department> allDepartments = new ArrayList<>();
		String sqlGetAllDepartments = "SELECT * FROM department";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetAllDepartments);
		while(results.next()) {
			Department dept = mapRowToDepartment(results);
			allDepartments.add(dept);
		}
		return allDepartments;
	}

	@Override
	public List<Department> searchDepartmentsByName(String nameSearch) {
		List<Department> departments = new ArrayList<>();
		String sqlSearchDeptByName = "SELECT * FROM department WHERE name ILIKE '%'||?||'%'";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSearchDeptByName, nameSearch);
		
		while(results.next()) {
			Department dept = mapRowToDepartment(results);
			departments.add(dept);
		}
		
		return departments;
	}

	@Override
	public void saveDepartment(Department updatedDepartment) {
		String sqlUpdateDept = "UPDATE department SET name = ? WHERE department_id = ?";
		
		jdbcTemplate.update(sqlUpdateDept, updatedDepartment.getName(), updatedDepartment.getId());
	}

	@Override
	public Department createDepartment(Department newDepartment) {
		String sqlNewDept = "INSERT INTO department (department_id, name) VALUES (?, ?)";
		
		Long id = getNextDepartmentId();
		
		jdbcTemplate.update(sqlNewDept, newDepartment.getName());
		return newDepartment;
	}

	@Override
	public Department getDepartmentById(Long id) {
		Department dept = null;
		
		String sqlFindDeptById = "SELECT department_id, name FROM department " +
								" WHERE department_id = ?";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindDeptById, id);
		
		if(results.next()) {
			dept = mapRowToDepartment(results);
		}
		return dept;
	}
	
	// helper methods
	
	private Department mapRowToDepartment(SqlRowSet results) {
		Department dept = new Department();
		dept.setId(results.getLong("department_id"));
		dept.setName(results.getString("name"));
		return dept;
	}
	
	private Long getNextDepartmentId() {
		SqlRowSet nextIdResult = jdbcTemplate.queryForRowSet("SELECT nextval('seq_department_id')");
		
		if(nextIdResult.next()) {
			return nextIdResult.getLong(1); // 1 because dept_id is in column 1
		}
		throw new RuntimeException("Error in getNextDepartmentId");
	}

}
