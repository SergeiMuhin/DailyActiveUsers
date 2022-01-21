package com.dailyuser.app.logic;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.stream.Stream;

import org.springframework.stereotype.Component;

import com.dailyuser.app.Boundtry.DailyBoundaryResponse;
import com.dailyuser.app.handler.IDailyActiveUsers;

@Component
public class DailyActiveUsers implements IDailyActiveUsers {

	public DailyBoundaryResponse dailyActiveUsersCounter(String fileName, String date) {

		Map<String, HashSet<String>> mainHash = new HashMap<String, HashSet<String>>();

		try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
			// For each Line Create data Structure
			stream.forEach(line -> {
				String[] customerInfo = line.split(("[, ]+"));
				HashSet<String> myHash = new HashSet<String>();
				mainHash.putIfAbsent(customerInfo[1], myHash);
				mainHash.get(customerInfo[1]).add(customerInfo[0]);
			});

		} catch (IOException e) {
			e.printStackTrace();
		}

		// Setting the returned JSON Boundary
		DailyBoundaryResponse DailyUserCount = new DailyBoundaryResponse();
		DailyUserCount.setCount(mainHash.get(date).size());
		DailyUserCount.setDate(date);

		// Return Same object but with Count and Null fileLocation
		return DailyUserCount;
	}

}