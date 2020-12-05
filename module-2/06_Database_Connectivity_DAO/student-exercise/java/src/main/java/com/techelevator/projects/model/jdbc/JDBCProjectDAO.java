package com.techelevator.projects.model.jdbc;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.model.Project;
import com.techelevator.projects.model.ProjectDAO;

public class JDBCProjectDAO implements ProjectDAO {

	private JdbcTemplate jdbcTemplate;

	public JDBCProjectDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Project> getAllActiveProjects() {
		List<Project> allActiveProjects = new ArrayList<>();
		String sqlGetAllActiveProjects = "SELECT * FROM project WHERE (now() BETWEEN from_date AND to_date)"
				+ " OR  (now() > from_date AND to_date IS NULL)" + " OR (now() < to_date AND from_date IS NULL)";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetAllActiveProjects);
		while (results.next()) {
			Project temp = mapRowToProject(results); // Project java object
			// add temp to the ArrayList
			allActiveProjects.add(temp);
		}
		return allActiveProjects;
	}

	@Override
	public void removeEmployeeFromProject(Long projectId, Long employeeId) {
		String sqlRemoveEmpFromProject = "DELETE FROM project_employee" + 
				" WHERE employee_id = ? AND project_id = ?";
		
		jdbcTemplate.update(sqlRemoveEmpFromProject, projectId, employeeId);
	}

	@Override
	public void addEmployeeToProject(Long projectId, Long employeeId) {
		String sqlAddEmpToProject = "INSERT INTO project_employee (project_id, employee_id) VALUES (?, ?)";
		
		jdbcTemplate.update(sqlAddEmpToProject, projectId, employeeId);
		
	}
	
	private Project mapRowToProject(SqlRowSet results) {
		Project temp = new Project();
		Long id = results.getLong("project_id"); // created local variable called id that holds results from db
		temp.setId(id); // set the java object id
		temp.setName(results.getString("name"));
		if (results.getDate("from_date") != null) {
			temp.setStartDate(results.getDate("from_date").toLocalDate());
		}
		if (results.getDate("to_date") != null) {
			temp.setEndDate(results.getDate("to_date").toLocalDate());
		}
		return temp;
	}

}
