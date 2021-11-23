package io.ailtonbsj.projeto1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("agenda")
public class AgendaController {
	@Autowired
	private ConsumingApi consumingApi;
	
	@GetMapping
	public Contact returnContact() {
		return consumingApi.returnContact();
	}
}
