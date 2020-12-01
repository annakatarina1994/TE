package com.techelevator.city;

import java.util.List;

public interface CityDAO {

	public void save(City newCity);  //CREATE
	public City findCityById(long id);  // READ
	public List<City> findCityByCountryCode(String countryCode);  // READ
	public List<City> findCityByDistrict(String district);  // READ
	public void update(City city);  // UPDATE
	public void delete(long id);  // DELETE
}
