package io.ailtonbsj.projeto1.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import io.ailtonbsj.projeto1.entity.User;
import io.ailtonbsj.projeto1.repository.UserRepository;

@Component
@Transactional
public class DataInitilizr implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	UserRepository userRepository;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {

		List<User> users = userRepository.findAll();

		if (users.isEmpty()) {
			createUser("Joao", "joao@gmail.com");
			createUser("Maria", "maria@gmail.com");
			createUser("Jose", "jose@gmail.com");
		}

//		User user = userRepository.findById("2");
//		System.out.println(user.getName());
		// userRepository.delete(user);

		User user = userRepository.findByName("Jose");
		System.out.println(user.getName());

//		user = userRepository.findBySubtringName("oa");
//		System.out.println(user.getName());
	}

	private void createUser(String name, String email) {
		User user = new User();
		user.setEmail(email);
		user.setName(name);
		userRepository.save(user);
	}
}
