package io.ailtonbsj.projeto1.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.ailtonbsj.projeto1.entity.User;

@RestController
public class ApiUserController {
	@RequestMapping(value = "api/user/{name}", method = RequestMethod.GET)
	public List<User> getUsers(@PathVariable String name) {
		List<User> users = new ArrayList<>();
		users.add(new User("Mary", "mary@gmail.com"));
		users.add(new User("Joseph", "joseph@gmail.com"));
		users.add(new User(name, name+"@gmail.com"));
		return users;
	}
	
	@RequestMapping(value = "api/user", method = RequestMethod.POST)
	public User setUser(@RequestBody User user) {
		return user;
	}
}
