package com.techelevator.projects.model.jdbc;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.model.Employee;
import com.techelevator.projects.model.EmployeeDAO;

public class JDBCEmployeeDAO implements EmployeeDAO {

	private JdbcTemplate jdbcTemplate;

	public JDBCEmployeeDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Employee> getAllEmployees() {
		return new ArrayList<>();
	}

	@Override
	public List<Employee> searchEmployeesByName(String firstNameSearch, String lastNameSearch) {
		return new ArrayList<>();
	}

	@Override
	public List<Employee> getEmployeesByDepartmentId(long id) {
		return new ArrayList<>();
	}

	@Override
	public List<Employee> getEmployeesWithoutProjects() {
		return new ArrayList<>();
	}

	@Override
	public List<Employee> getEmployeesByProjectId(Long projectId) {
		List<Employee> allEmployees = new ArrayList<>();
		String sqlGetEmployeesByProjectId = "SELECT * FROM employee e" + 
				" JOIN project_employee pe ON e.employee_id = pe.employee_id" + 
				" WHERE pe.project_id = ?";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetEmployeesByProjectId, projectId);
		
		while (results.next()) {
			Employee temp = mapRowToEmployee(results);
			allEmployees.add(temp);
		}
		
		return allEmployees;
	}

	@Override
	public void changeEmployeeDepartment(Long employeeId, Long departmentId) {
		
	}
	
	
	private Employee mapRowToEmployee(SqlRowSet results) {
		Employee emp = new Employee();
		
		emp.setId(results.getLong("employee_id"));
		emp.setDepartmentId(results.getLong("department_id"));
		emp.setFirstName(results.getString("first_name"));
		emp.setLastName(results.getString("last_name"));
		emp.setBirthDay(results.getDate("birth_date").toLocalDate());
		emp.setGender(results.getString("gender").charAt(0));  // getString returns a string, but we only want the 0th (first) position so charAt(0) gives us back only 1 character
		emp.setHireDate(results.getDate("hire_date").toLocalDate());
		return emp;
	}

}
