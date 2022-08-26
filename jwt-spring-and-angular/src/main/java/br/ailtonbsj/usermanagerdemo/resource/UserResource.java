package br.ailtonbsj.usermanagerdemo.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ailtonbsj.usermanagerdemo.exception.ExceptionHandling;

@RestController
@RequestMapping(value = "/user")
public class UserResource extends ExceptionHandling {

    @GetMapping("/home")
    public String showUser() {
        return "application works";
    }

}
