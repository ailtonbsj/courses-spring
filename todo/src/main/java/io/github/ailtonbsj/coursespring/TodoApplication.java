package io.github.ailtonbsj.coursespring;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.github.ailtonbsj.coursespring.model.Todo;
import io.github.ailtonbsj.coursespring.repository.TodoRepository;

@SpringBootApplication
public class TodoApplication {
	
	@Autowired
	private TodoRepository todoRepository;
	
	@Bean
	public CommandLineRunner init() {
		return new CommandLineRunner() {
			
			@Override
			public void run(String... args) throws Exception {
				Todo todo = new Todo();
				todo.setDescription("Estudar Spring");
				todo.setCreatedDate(LocalDateTime.now());
				todoRepository.save(todo);
			}
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(TodoApplication.class, args);
	}

}
