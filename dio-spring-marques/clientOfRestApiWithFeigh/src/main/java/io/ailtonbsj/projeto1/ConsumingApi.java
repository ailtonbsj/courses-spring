package io.ailtonbsj.projeto1;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "agenda", url = "http://localhost:8080/contact")
public interface ConsumingApi {
	@RequestMapping(method = RequestMethod.GET, value = "/")
	Contact returnContact();
}
