package io.ailtonbsj.projeto1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ClientOfRestApiWithFeighApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientOfRestApiWithFeighApplication.class, args);
	}

}
