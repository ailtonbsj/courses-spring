package br.ailtonbsj.jwtspringsecurity;

import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.ailtonbsj.jwtspringsecurity.domain.Role;
import br.ailtonbsj.jwtspringsecurity.domain.User;
import br.ailtonbsj.jwtspringsecurity.service.UserService;

@SpringBootApplication
public class JwtSpringSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(JwtSpringSecurityApplication.class, args);
	}

	@Bean
	CommandLineRunner run(UserService userService) {
		return args -> {
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_MANAGER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

			userService.saveUser(new User(null, "User", "user", "pass", new ArrayList<>()));
			userService.saveUser(new User(null, "Manager", "manager", "pass", new ArrayList<>()));
			userService.saveUser(new User(null, "Admin", "admin", "pass", new ArrayList<>()));
			userService.saveUser(new User(null, "Root", "root", "pass", new ArrayList<>()));

			userService.addRoleToUser("user", "ROLE_USER");
			userService.addRoleToUser("manager", "ROLE_USER");
			userService.addRoleToUser("manager", "ROLE_MANAGER");
			userService.addRoleToUser("admin", "ROLE_ADMIN");
			userService.addRoleToUser("root", "ROLE_SUPER_ADMIN");
			userService.addRoleToUser("root", "ROLE_ADMIN");
			userService.addRoleToUser("root", "ROLE_USER");
		};
	}

}
