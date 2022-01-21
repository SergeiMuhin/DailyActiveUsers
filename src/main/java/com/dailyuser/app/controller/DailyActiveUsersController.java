package com.dailyuser.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;

import com.dailyuser.app.Boundtry.DailyBoundaryRequest;
import com.dailyuser.app.Boundtry.DailyBoundaryResponse;
import com.dailyuser.app.handler.IDailyActiveUsers;

@RestController
public class DailyActiveUsersController {
	final private IDailyActiveUsers DailyCounter;

	@Autowired
	public DailyActiveUsersController(IDailyActiveUsers dailyCounter) {
		DailyCounter = dailyCounter;
	}

	// http://localhost:8080/api/dailyactiveuser/count
	@RequestMapping(method = RequestMethod.GET, path = "/api/dailyactiveuser/count", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public DailyBoundaryResponse countinfo(@RequestBody DailyBoundaryRequest dailyActiveUsers) {
		return DailyCounter.dailyActiveUsersCounter(dailyActiveUsers.getFileLocation(), dailyActiveUsers.getDate());
	}

}