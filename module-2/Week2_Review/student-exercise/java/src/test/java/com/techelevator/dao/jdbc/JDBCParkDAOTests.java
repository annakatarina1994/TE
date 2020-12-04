package com.techelevator.dao.jdbc;

import com.techelevator.dao.ParkDAO;
import com.techelevator.model.Park;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

public class JDBCParkDAOTests extends BaseDAOTests {

    private ParkDAO dao;

    @Before
    public void setup() {
        dao = new JDBCParkDAO(dataSource);
      
    }

//    @Test
//    public void getParksTest_Should_ReturnAllParksInLocationAlphaOrder() {
//        List<Park> parks = dao.getAllParks();
//
//        assertEquals(3, parks.size());
//        assertEquals("Maine", parks.get(0).getLocation());
//        assertEquals("Ohio", parks.get(1).getLocation());
//        assertEquals("Utah", parks.get(2).getLocation());
//    }

    
    @Test
    public void getParksTest_should_return_one_more_after_create_park() {
    	List<Park> parks = dao.getAllParks();
    	int sizeBeforeAdd = parks.size();
    	
    	  Park park = new Park();
          park.setName("SQL PARK");
          park.setLocation("SQL City");
          park.setEstablishDate(LocalDate.now());
          park.setArea(2000);
          park.setVisitors(2000);
          park.setDescription("SQL Park is ridiculously amazing");
          
          dao.createNewPark(park);
          
          List<Park> parksAfterAdd = dao.getAllParks();
          int  sizeAfterAdd = parksAfterAdd.size();
          
          assertEquals(sizeBeforeAdd + 1, sizeAfterAdd);
    	
    }
}
