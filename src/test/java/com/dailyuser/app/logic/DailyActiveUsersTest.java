package com.dailyuser.app.logic;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.dailyuser.app.Boundtry.DailyBoundaryResponse;

public class DailyActiveUsersTest {

	@Test
	public void testlogic() {
		System.out.println(System.getProperty("user.dir"));
		DailyActiveUsers dailyLogicTest = new DailyActiveUsers();
		DailyBoundaryResponse reponse = dailyLogicTest.dailyActiveUsersCounter(System.getProperty("user.dir") + "/src/test/java/TestInput/TestInput",
				"01/01/2020");
		assertEquals(3, reponse.getCount());
		assertEquals("01/01/2020", reponse.getDate());
	}

	@Test
	public void testBadData() {
		Assertions.assertThrows(NullPointerException.class, () -> {
			DailyActiveUsers dailyLogicTest = new DailyActiveUsers();
			DailyBoundaryResponse reponse = dailyLogicTest
					.dailyActiveUsersCounter(System.getProperty("user.dir") + "/src/test/java/TestInput/TestInput", "0101/2020");
		});
	}

	@Test
	public void testBadFileLocation() {
		Assertions.assertThrows(NullPointerException.class, () -> {
			DailyActiveUsers dailyLogicTest = new DailyActiveUsers();
			DailyBoundaryResponse reponse = dailyLogicTest.dailyActiveUsersCounter("badInputLocation",
					"01/01/2020");
		});
	}
}
