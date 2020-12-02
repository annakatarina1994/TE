package com.techelevator.city;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.SQLException;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class JDBCCityDAOIntegrationTest {

	private static final String TEST_COUNTRY = "XYZ";

	/* Using this particular implementation of DataSource so that
	 * every database interaction is part of the same database
	 * session and hence the same database transaction */
	private static SingleConnectionDataSource dataSource;
	private JDBCCityDAO dao;

	/* Before any tests are run, this method initializes the datasource for testing. */
	@BeforeClass //only runs once at the beginning of running this class (file)
	public static void setupDataSource() {
		dataSource = new SingleConnectionDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/world");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");
		
		// disable autocommit for connections returned by this datasource
		// this will allow us to rollback any changes after each test
		// so we don't actually modify the database
		dataSource.setAutoCommit(false);
	}

	/* After all tests have finished running, this method will close the DataSource */
	@AfterClass //only runs once when we're all done
	public static void closeDataSource() throws SQLException {
		dataSource.destroy();
	}

	
	// runs once before each test method
	@Before
	public void setup() {
		String sqlInsertCountry = "INSERT INTO country (code, name, continent, region, surfacearea, indepyear, population, "
				+ "lifeexpectancy, gnp, gnpold, localname, governmentform, headofstate, capital, code2) VALUES "
				+ "(?, 'Afghanistan', 'Asia', 'Southern and Central Asia', 652090, 1919, 22720000, 45.9000015, 5976.00, NULL, "
				+ "'Afganistan/Afqanestan', 'Islamic Emirate', 'Mohammad Omar', 1, 'AF')";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(sqlInsertCountry, TEST_COUNTRY);
		
		dao = new JDBCCityDAO(dataSource);

	}

	/* After each test, we rollback any changes that were made to the database so that
	 * everything is clean for the next test */
	@After
	public void rollback() throws SQLException {
		dataSource.getConnection().rollback();
	}

	@Test
	public void save_new_city_and_read_it_back() {
		City theCity = getCity("SQL Station", "South Dakota", "USA", 65535);
		dao.save(theCity);
		City savedCity = dao.findCityById(theCity.getId());
		
		assertNotEquals(null, theCity.getId());
		assertCitiesAreEqual(theCity, savedCity);
	}

	@Test
	public void returns_cities_by_country_code() {
		City theCity = getCity("SQL Station", "Montana", TEST_COUNTRY, 42);
		
		dao.save(theCity);
		List<City> results = dao.findCityByCountryCode(TEST_COUNTRY);
		
		assertNotNull(results); // make sure we actually get back some data
		assertEquals(1, results.size()); // we should get back only 1 city
		
		City savedCity = results.get(0);
		assertCitiesAreEqual(theCity, savedCity);
	}

	@Test
	public void returns_multiple_cities_by_country_code() {
		dao.save(getCity("SQL Station", "Montana", TEST_COUNTRY, 652323));
		dao.save(getCity("Postgres Pt", "Alaska", TEST_COUNTRY, 235));
		
		List<City> results = dao.findCityByCountryCode(TEST_COUNTRY);
		
		assertNotNull(results);
		assertEquals(2, results.size());
	}

	@Test
	public void returns_cities_by_district() {
		City theCity = getCity("SQL Station", "Tech Elevator", TEST_COUNTRY, 654);
		dao.save(theCity);
		
		List<City> results = dao.findCityByDistrict("Tech Elevator");
		
		assertNotNull(results);
		assertEquals(1, results.size());
		
		City savedCity = results.get(0);
		assertCitiesAreEqual(theCity, savedCity);
	}

	
	// helper methods
	/*
	 * getCity creates a java City object for us to compare with
	 */
	private City getCity(String name, String district, String countryCode, int population) {
		City theCity = new City();
		theCity.setName(name);
		theCity.setDistrict(district);
		theCity.setCountryCode(countryCode);
		theCity.setPopulation(population);
		return theCity;
	}

	/*
	 * compares the Java objects and verifies that all fields are the same
	 */
	private void assertCitiesAreEqual(City expected, City actual) {
		assertEquals(expected.getId(), actual.getId());
		assertEquals(expected.getName(), actual.getName());
		assertEquals(expected.getDistrict(), actual.getDistrict());
		assertEquals(expected.getCountryCode(), actual.getCountryCode());
		assertEquals(expected.getPopulation(), actual.getPopulation());
	}
}
