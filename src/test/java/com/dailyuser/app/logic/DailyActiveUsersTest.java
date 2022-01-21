package com.dailyuser.app.logic;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.dailyuser.app.Boundtry.DailyBoundaryResponse;

public class DailyActiveUsersTest {

	@Test
	public void testlogic() {
		DailyActiveUsers dailyLogicTest = new DailyActiveUsers();
		DailyBoundaryResponse reponse = dailyLogicTest.dailyActiveUsersCounter("C:\\Users\\Sergei\\Desktop\\input.txt",
				"01/01/2020");
		assertEquals(3, reponse.getCount());
		assertEquals("01/01/2020", reponse.getDate());
	}
	
    @Test
	public void testBadData() {
		Assertions.assertThrows(NullPointerException.class, () -> {
			DailyActiveUsers dailyLogicTest = new DailyActiveUsers();
			DailyBoundaryResponse reponse = dailyLogicTest
					.dailyActiveUsersCounter("C:\\Users\\Sergei\\Desktop\\input.txt", "0101/2020");
		});
	}
}
