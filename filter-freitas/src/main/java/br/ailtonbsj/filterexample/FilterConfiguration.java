package br.ailtonbsj.filterexample;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfiguration {
    @Bean
    public FilterRegistrationBean<FilterController> registrationBean() {
        FilterRegistrationBean<FilterController> register = new FilterRegistrationBean<>();
        register.setFilter(new FilterController());
        register.addUrlPatterns("/home", "/third");
        register.setOrder(2);
        return register;
    }
}
