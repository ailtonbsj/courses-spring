package io.ailtonbsj.projeto2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("prod")
public class ProdConfig {
	@Bean
	public BeanProd beanProd() {
		return new BeanProd();
	}
}
