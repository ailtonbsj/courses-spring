package io.github.restforfeign;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("contact")
public class AgendaController {
	@GetMapping
	public Contact returnContact() {
		return Contact.builder()
				.id(1L)
				.name("Ailton")
				.telephone("99999-999")
				.build();
	}
}
