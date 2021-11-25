package io.ailtonbsj.springBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import io.ailtonbsj.springBootTest.controller.TestController;

public class TestUnitController {
	@Test
	public void testUnit() {
		TestController controller = new TestController();
		String result = controller.greeting("DIO");
		assertEquals("Bem vindo, DIO", result);
		
		result = controller.greeting("Mary");
		assertEquals("Bem vindo, Mary", result);
	}
}
