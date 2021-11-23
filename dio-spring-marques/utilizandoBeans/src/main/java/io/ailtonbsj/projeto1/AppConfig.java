package io.ailtonbsj.projeto1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
	@Bean
	public Book getBook() {
		return new Book();
	}
	
	@Bean
	public AuthorBook getAuthorBook() {
		return new Author();
	}
}
