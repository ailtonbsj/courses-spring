package io.github.ailtonbsj.heroesapi;

import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import static io.github.ailtonbsj.heroesapi.constants.HeroesConstant.*;

@SpringBootApplication
@EnableDynamoDBRepositories
public class HeroesApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(HeroesApiApplication.class, args);
		System.out.println("Super powers with web flux");
	}

}
