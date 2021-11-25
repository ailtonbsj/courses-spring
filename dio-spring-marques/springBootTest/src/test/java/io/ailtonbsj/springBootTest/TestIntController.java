package io.ailtonbsj.springBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;

@WebMvcTest
@ExtendWith(SpringExtension.class)
public class TestIntController {
	@Autowired
	private MockMvc mvc;
	
	@Test
	public void testInt() throws Exception {
		RequestBuilder request = get("/test");
		MvcResult result = mvc.perform(request).andReturn();
		assertEquals("Bem vindo, DIO", result.getResponse().getContentAsString());
	}
	
	@Test
	public void testIntWithArgs() throws Exception {
		mvc.perform(get("/test?name=John!")).andExpect(content().string("Bem vindo, John!"));
	}
}
