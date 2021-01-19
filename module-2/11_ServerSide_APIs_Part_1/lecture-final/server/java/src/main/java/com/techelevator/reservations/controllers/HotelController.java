package com.techelevator.reservations.controllers;

import java.util.List;
import java.util.*;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.reservations.dao.HotelDAO;
import com.techelevator.reservations.dao.MemoryHotelDAO;
import com.techelevator.reservations.dao.MemoryReservationDAO;
import com.techelevator.reservations.dao.ReservationDAO;
import com.techelevator.reservations.models.Hotel;
import com.techelevator.reservations.models.Reservation;

@CrossOrigin
@RestController
public class HotelController {

	private HotelDAO hotelDAO;
	private ReservationDAO reservationDAO;

	public HotelController() {
		this.hotelDAO = new MemoryHotelDAO();
		this.reservationDAO = new MemoryReservationDAO(hotelDAO);
	}

	/**
	 * Return All Hotels
	 *
	 * @return a list of all hotels in the system
	 */
	@RequestMapping(path = "/hotels", method = RequestMethod.GET)
	public List<Hotel> list() {
		return hotelDAO.list();
	}

	/**
	 * Return hotel information
	 *
	 * @param id the id of the hotel
	 * @return all info for a given hotel
	 */
	@RequestMapping(path = "/hotels/{id}", method = RequestMethod.GET)
	public Hotel get(@PathVariable int id) {
		return hotelDAO.get(id);
	}

	/*
	 * REturn all Reservations path: http://localhost:port#/reservations GET method
	 */
	@RequestMapping(path = "/reservations", method = RequestMethod.GET)
	public List<Reservation> listReservations() {
		return reservationDAO.findAll();
	}

	/*
	 * Return a reservation by id path: http://localhost:port#/reservations/{id} GET
	 * method
	 */
	@RequestMapping(path = "/reservations/{id}", method = RequestMethod.GET)
	public Reservation getReservation(@PathVariable("id") int reservationId) {
		return reservationDAO.get(reservationId);
	}

	/*
	 * Add new reservation path: http://localhost:port#/hotels/{id}/reservations
	 * POST method
	 */
	@RequestMapping(path = "/hotels/{id}/reservations", method = RequestMethod.POST)
	public Reservation addReservation(@RequestBody Reservation reservation, @PathVariable int id) {
		return reservationDAO.create(reservation, id);
	}

	/*
	 * List all reservations by hotel id path:
	 * http://localhost:port#/hotels/{id}/reservations GET method
	 */
	@RequestMapping(path = "/hotels/{id}/reservations", method = RequestMethod.GET)
	public List<Reservation> getReservationByHotelId(@PathVariable int id) {
		return reservationDAO.findByHotel(id);
	}

	/*
	 * filter hotels by city and state path:
	 * http://localhost:port#/filter?state={state}&city={city} GET method
	 */
	@RequestMapping(path = "/filter", method = RequestMethod.GET)
    public List<Hotel> filterByStateAndCity(@RequestParam String state, @RequestParam (required = false) String city){
    	List<Hotel> hotels = list();  // call method above
    	List<Hotel> filteredHotels = new ArrayList<Hotel>();
    	
    	for (Hotel hotel: hotels) {
	    	if (city != null) {
	    		if (hotel.getAddress().getCity().toLowerCase().equals(city.toLowerCase()) && hotel.getAddress().getState().toLowerCase().equals(state.toLowerCase())) {
	    			filteredHotels.add(hotel);
	    		}
	    	} else {
	    		if (hotel.getAddress().getState().toLowerCase().equals(state.toLowerCase())) {
	    			filteredHotels.add(hotel);
	    		}
	    	}
    	}
    	return filteredHotels;
    }

}
