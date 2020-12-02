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
		return new ArrayList<>();
	}

	@Override
	public void saveDepartment(Department updatedDepartment) {
		String sqlUpdateDept = "UPDATE department SET name = ? WHERE department_id = ?";
		
		jdbcTemplate.update(sqlUpdateDept, updatedDepartment.getName(), updatedDepartment.getId());
	}

	@Override
	public Department createDepartment(Department newDepartment) {
//		String sqlInsertDept = "INSERT INTO department (department_id, name)" + 
//								" VALUES (?, ?)";
//		jdbcTemplate.update(sqlInsertDept, newDepartment.getId(), newDepartment.getName());
		return newDepartment;
	}

	@Override
	public Department getDepartmentById(Long id) {
		return null;
	}
	
	private Department mapRowToDepartment(SqlRowSet results) {
		Department dept = new Department();
		dept.setId(results.getLong("department_id"));
		dept.setName(results.getString("name"));
		return dept;
	}

}
