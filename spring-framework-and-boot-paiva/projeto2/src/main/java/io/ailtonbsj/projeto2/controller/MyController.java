package io.ailtonbsj.projeto2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {
	public String hello() {
		System.out.println("Method executed!");
		return "hello";
	}
	
	@RequestMapping("/")
	public String welcome() {
		System.out.println("Welcome people!");
		return "Hello darkness my old friend!";
	}
}
