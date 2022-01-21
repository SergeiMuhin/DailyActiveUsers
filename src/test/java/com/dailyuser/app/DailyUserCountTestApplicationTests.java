package com.dailyuser.app;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.rmi.UnexpectedException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dailyuser.app.Boundtry.DailyBoundaryRequest;
import com.dailyuser.app.Boundtry.DailyBoundaryResponse;
import com.dailyuser.app.controller.DailyActiveUsersController;

@SpringBootTest
class DailyUserCountTestApplicationTests {
	@Autowired
	private DailyActiveUsersController controllerAPI;
	

	@Test
	void contextLoads() {
		
	}
	
	@Test
	public void countTest() 
	{  
		DailyBoundaryRequest dailyRequest = new DailyBoundaryRequest();
		dailyRequest.setDate("01/01/2020");
		dailyRequest.setFileLocation("C:\\Users\\Sergei\\Desktop\\input.txt");
		DailyBoundaryResponse reponse = controllerAPI.countinfo(dailyRequest);
	    assertEquals(3, reponse.getCount());
	    assertEquals("01/01/2020", reponse.getDate());
	}
	
	@Test
	public void countBadDateDateTest() 
	{  
		Assertions.assertThrows(NullPointerException.class, ()->{		DailyBoundaryRequest dailyRequest = new DailyBoundaryRequest();
		dailyRequest.setDate("0101/2022"); // no such date // bad date
		dailyRequest.setFileLocation("C:\\Users\\Sergei\\Desktop\\input.txt");
		DailyBoundaryResponse reponse = controllerAPI.countinfo(dailyRequest);
	  });
	}
	
	@Test
	public void countBadFilelocationDataTest() 
	{  
		Assertions.assertThrows(NullPointerException.class, ()->{		DailyBoundaryRequest dailyRequest = new DailyBoundaryRequest();
		dailyRequest.setDate("01/01/2022"); // no such date // bad date
		dailyRequest.setFileLocation("C:\\Users\\Sergei\\Des\\input.txt");
		DailyBoundaryResponse reponse = controllerAPI.countinfo(dailyRequest);
	  });
	}
}
