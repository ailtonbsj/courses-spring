package br.ailtonbsj.jwtspringsecurity;

import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import br.ailtonbsj.jwtspringsecurity.domain.RoleModel;
import br.ailtonbsj.jwtspringsecurity.domain.UserModel;
import br.ailtonbsj.jwtspringsecurity.service.UserService;

@SpringBootApplication
public class JwtSpringSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(JwtSpringSecurityApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run(UserService userService) {
		return args -> {
			userService.saveRole(new RoleModel(null, "ROLE_USER"));
			userService.saveRole(new RoleModel(null, "ROLE_MANAGER"));
			userService.saveRole(new RoleModel(null, "ROLE_ADMIN"));
			userService.saveRole(new RoleModel(null, "ROLE_SUPER_ADMIN"));

			userService.saveUser(new UserModel(null, "User", "user", "pass", new ArrayList<>()));
			userService.saveUser(new UserModel(null, "Manager", "manager", "pass", new ArrayList<>()));
			userService.saveUser(new UserModel(null, "Admin", "admin", "pass", new ArrayList<>()));
			userService.saveUser(new UserModel(null, "Root", "root", "pass", new ArrayList<>()));

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
