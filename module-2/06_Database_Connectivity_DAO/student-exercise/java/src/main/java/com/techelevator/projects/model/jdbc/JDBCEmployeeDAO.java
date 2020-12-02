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
		List<Employee> allEmployees = new ArrayList<>();
		String sqlGetAllEmployees = "SELECT * FROM employee";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetAllEmployees);
		while(results.next()) {
			Employee emp = mapRowToEmployee(results);
			allEmployees.add(emp);
		}
		return allEmployees;
	}

	@Override
	public List<Employee> searchEmployeesByName(String firstNameSearch, String lastNameSearch) {
		List<Employee> employees = new ArrayList<>();
		String sqlFindEmployeeByName = "SELECT * FROM employee WHERE first_name ILIKE '%'||?||'%' AND last_name ILIKE '%'||?||'%'";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindEmployeeByName, firstNameSearch, lastNameSearch);
		
		while(results.next()) {
			Employee emp = mapRowToEmployee(results);
			employees.add(emp);
		}
		
		return employees;
	}

	@Override
	public List<Employee> getEmployeesByDepartmentId(long id) {
		List<Employee> employees = new ArrayList<>();
		String sqlFindEmpsById = "SELECT * FROM employee WHERE department_id = ?";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindEmpsById, id);
		
		while(results.next()) {
			Employee emp = mapRowToEmployee(results);
			employees.add(emp);
		}
		return employees;
	}

	@Override
	public List<Employee> getEmployeesWithoutProjects() {
		List<Employee> employees = new ArrayList<>();
		String sqlNoProjectsEmps = "SELECT * FROM employee" + 
									" LEFT JOIN project_employee ON employee.employee_id = project_employee.employee_id" + 
									" WHERE project_employee.project_id IS NULL";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlNoProjectsEmps);
		
		while(results.next()) {
			Employee emp = mapRowToEmployee(results);
			employees.add(emp);
		}
		return employees;
	}

	@Override
	public List<Employee> getEmployeesByProjectId(Long projectId) {
		List<Employee> allEmployees = new ArrayList<>();
		String sqlGetEmployeesByProjectId = "SELECT * FROM employee" + 
				" JOIN project_employee ON employee.employee_id = project_employee.employee_id" + 
				" WHERE project_employee.project_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetEmployeesByProjectId, projectId);
		
		while(results.next()) {
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
		emp.setGender(results.getString("gender").charAt(0));
		return emp;
	}

}
