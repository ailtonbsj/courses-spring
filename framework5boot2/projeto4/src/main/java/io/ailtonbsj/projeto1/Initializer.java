package io.ailtonbsj.projeto1;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import io.ailtonbsj.projeto1.entity.Functionality;
import io.ailtonbsj.projeto1.entity.Role;
import io.ailtonbsj.projeto1.entity.User;
import io.ailtonbsj.projeto1.repository.UserRepository;

@Component
public class Initializer implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	private UserRepository userRepository;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		Functionality add = new Functionality("Add user");
		Functionality show = new Functionality("Show user");
		Functionality list = new Functionality("List all users");
		Functionality patch = new Functionality("Patch user");
		Functionality del = new Functionality("Remove user");
		
		Role admin = new Role("Admin", StatusRole.ENABLE, Arrays.asList(add, patch));
		Role professor = new Role("Professor", StatusRole.ENABLE, Arrays.asList(show, list));
		Role it = new Role("IT Suport", StatusRole.ENABLE, Arrays.asList(del));
		
		User mary = new User("Mary", "mary@local", Arrays.asList(admin));
		User joseph = new User("Joseph", "joseph@local", Arrays.asList(professor, it));

		userRepository.save(joseph);
		userRepository.save(mary);
		
		List<User> users = userRepository.findAll();
		for (User user : users) {
			System.out.println(user);
		}
		
		User user = userRepository.findByNameIgnoreCase("joseph");
		System.out.println(user);
		
		User byEmail = userRepository.findBySliceEmail("ary");
		System.out.println(byEmail);
		
//		Role admin = new Role("Admin", StatusRole.ENABLE, Arrays.asList(add, show, list, patch, del));
//		Role principal = new Role("Principal", StatusRole.ENABLE, Arrays.asList(add, show, list, patch));
//		Role professor = new Role("Professor", StatusRole.ENABLE, Arrays.asList(add, show, list));
//		Role teacher = new Role("Teacher", StatusRole.ENABLE, Arrays.asList(add, show, list));
//		Role student = new Role("Student", StatusRole.ENABLE, Arrays.asList(list));
//		Role it = new Role("IT Suport", StatusRole.ENABLE, Arrays.asList(show, list, patch));
//		Role intern = new Role("Intern", StatusRole.ENABLE, Arrays.asList(show, patch));
//		Role general = new Role("General service", StatusRole.ENABLE, Arrays.asList(show));
//		Role parent = new Role("Parent", StatusRole.DISABLE, Arrays.asList());
//		roleRepository.save(teacher);
//		roleRepository.save(principal);
//		roleRepository.save(student);
		
//		roleRepository.save(admin);
//		roleRepository.save(professor);
//		roleRepository.save(it);
		
//		User john = new User("John", "john@local", Arrays.asList(student));
//		userRepository.save(john);
	}

}
