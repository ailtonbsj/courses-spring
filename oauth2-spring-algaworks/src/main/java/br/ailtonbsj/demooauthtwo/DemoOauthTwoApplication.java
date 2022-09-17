package br.ailtonbsj.demooauthtwo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.ailtonbsj.demooauthtwo.domain.Client;
import br.ailtonbsj.demooauthtwo.service.ClientService;

@SpringBootApplication
public class DemoOauthTwoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoOauthTwoApplication.class, args);
	}

	@Bean
	CommandLineRunner run(ClientService clientService) {
		return args -> {
			clientService.save(new Client(null, "John"));
			clientService.save(new Client(null, "Mary"));
			clientService.save(new Client(null, "Peter"));
			System.out.println("POPULATED!!!!!!!!");
		};
	}

}
