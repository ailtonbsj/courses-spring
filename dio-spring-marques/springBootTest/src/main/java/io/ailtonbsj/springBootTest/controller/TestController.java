package io.ailtonbsj.springBootTest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	@GetMapping("/test")
	public String greeting(@RequestParam(name="name", defaultValue = "DIO") String name) {
		return String.format("Bem vindo, %s", name);
	}
}
