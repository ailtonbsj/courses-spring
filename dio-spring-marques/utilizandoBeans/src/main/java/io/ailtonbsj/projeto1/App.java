package io.ailtonbsj.projeto1;

import java.util.UUID;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class App {

	public static void main(String[] args) {
		ApplicationContext factory = new AnnotationConfigApplicationContext(AppConfig.class);
		
		Book book = factory.getBean(Book.class);
		book.setName("Harry Potter and Philosopher's Stone");
		book.setId(UUID.randomUUID().toString());
		
		Author author = factory.getBean(Author.class);
		author.setName("J.K. Rowling");
		
		book.show();
		
		((AbstractApplicationContext) factory).close();
	}

}
