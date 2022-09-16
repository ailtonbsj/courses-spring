package io.ailtonbsj.projeto2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import io.ailtonbsj.projeto2.controller.MyController;

@SpringBootApplication
@ComponentScan(basePackages = { "io.ailtonbsj.projeto2", "io.ailtonbsj.projeto2.service", "io.ailtonbsj.projeto2.controller" })
public class Projeto2Application {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Projeto2Application.class, args);
		MyController ctl = (MyController) ctx.getBean("myController");
		ctl.hello();
		VehicleComponent vehicle = (VehicleComponent) ctx.getBean("vehicleComponent");
		vehicle.service();
	}

}
