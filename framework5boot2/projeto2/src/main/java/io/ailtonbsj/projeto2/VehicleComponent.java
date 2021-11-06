package io.ailtonbsj.projeto2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class VehicleComponent {
	@Autowired
	@Qualifier("carBean")
	private Vehicle vehicle;
	
	public void service() {
		vehicle.start();
		vehicle.stop();
	}
}
