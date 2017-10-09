package com.employees.control;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import com.tshirt.controller.HomeController;

public class AppTest {

	@Test
	public void entryPointTest() {
		HomeController home = new HomeController();
		String result = home.home();
		assertEquals( result, "Welcome to the T-Shirt e-Shop");
	}

}
