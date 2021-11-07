package io.ailtonbsj.projeto1;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import ch.qos.logback.core.status.Status;
import io.ailtonbsj.projeto1.entity.Role;
import io.ailtonbsj.projeto1.entity.User;
import io.ailtonbsj.projeto1.repository.RoleRepository;
import io.ailtonbsj.projeto1.repository.UserRepository;

@Component
public class Initializer implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private UserRepository userRepository;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		saveRole("Admin", StatusRole.ENABLE);
		saveRole("Principal", StatusRole.ENABLE);
		saveRole("Professor", StatusRole.ENABLE);
		saveRole("Teacher", StatusRole.ENABLE);
		saveRole("Student", StatusRole.ENABLE);
		saveRole("Intern", StatusRole.ENABLE);
		saveRole("IT Suport", StatusRole.ENABLE);
		saveRole("General service", StatusRole.ENABLE);
		saveRole("Parent", StatusRole.DISABLE);

		List<Role> enabledRoles = roleRepository.findByStatus(StatusRole.DISABLE);
		System.out.println("ALL ROLES DISABLED:");
		for (Role role : enabledRoles) {
			System.out.println(role.toString());
		}

		/* Iterate over all pages (Imperative way) */
		int pageSize = 3;
		PageRequest page = PageRequest.of(0, pageSize);
		Page<Role> roles = this.roleRepository.findAll(page);
		for (int index = 0; index < roles.getTotalPages(); index++) {
			PageRequest paged = PageRequest.of(index, pageSize);
			roles = this.roleRepository.findAll(paged);
			System.out.println("---- PAGE " + (index + 1) + " -----");
			for (Role role : roles) {
				System.out.println(role.toString());
			}
		}

		Role admin  = roleRepository.findByName("Admin");
		User mary = new User("Mary", "mary@local", admin);
		User joseph = new User("Joseph", "joseph@local", roleRepository.findByName("Admin"));
		User john = new User("John", "john@local", roleRepository.findByName("Student"));

		userRepository.save(joseph);
		userRepository.save(john);
		userRepository.save(mary);
		
		Role role = new Role("Guest", StatusRole.ENABLE);
		roleRepository.save(role);
		User guest = new User("Guest", "guest@local", role);
		userRepository.save(guest);
	}

	private void saveRole(String name, StatusRole status) {
		roleRepository.save(new Role(name, status));
	}

}
