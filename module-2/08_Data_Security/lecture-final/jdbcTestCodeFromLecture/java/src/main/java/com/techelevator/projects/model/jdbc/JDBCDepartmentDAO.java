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
		return new ArrayList<>();
	}

	@Override
	public List<Department> searchDepartmentsByName(String nameSearch) {
		return new ArrayList<>();
	}

	@Override
	public void saveDepartment(Department updatedDepartment) {
		
	}

	@Override
	public Department createDepartment(Department newDepartment) {
		String sqlNewDept = "INSERT INTO department (department_id, name) VALUES (?, ?)";
		
		Long id = getNextDepartmentId();
		newDepartment.setId(id);
		
		jdbcTemplate.update(sqlNewDept, newDepartment.getId(), newDepartment.getName());
		
		return newDepartment;
	}

	@Override
	public Department getDepartmentById(Long id) {
		Department theDepartment = null;
		
		String sqlFindDeptById = "SELECT department_id, name FROM department " +
		   "WHERE department_id = ?";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindDeptById, id);
		
		if (results.next()) {
			theDepartment = mapRowToDepartment(results);		
		}
		return theDepartment;
	}
	
	private Department mapRowToDepartment(SqlRowSet results) {
		Department theDept = new Department();
		
		theDept.setId(results.getLong("department_id"));
		theDept.setName(results.getString("name"));
		
		return  theDept;
	}
	
	private Long getNextDepartmentId() {
		SqlRowSet nextIdResult = jdbcTemplate.queryForRowSet("SELECT nextval ('seq_department_id')");
		
		if (nextIdResult.next()) {
			return nextIdResult.getLong(1);
		}
		throw new RuntimeException("Error in getNextDepartmentId");
	}

}
