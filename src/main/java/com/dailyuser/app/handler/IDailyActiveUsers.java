package com.dailyuser.app.handler;

import com.dailyuser.app.Boundtry.DailyBoundaryRequest;
import com.dailyuser.app.Boundtry.DailyBoundaryResponse;

public interface IDailyActiveUsers {
	DailyBoundaryResponse dailyActiveUsersCounter(String fileName, String date);
}