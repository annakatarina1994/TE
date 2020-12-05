package com.techelevator.dao;

import com.techelevator.model.Park;

import java.util.List;

public interface ParkDAO {

    List<Park> getAllParks();
    
    Park createNewPark(Park park);
    
    void deleteParkById(int parkId);
}
