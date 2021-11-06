package io.ailtonbsj.projeto2;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("bikeBean")
public class Bike implements Vehicle {
	@Override
	public void start() {
		System.out.println("Starting bike...");
	}

	@Override
	public void stop() {
		System.out.println("Stopping bike...");
	}
}
