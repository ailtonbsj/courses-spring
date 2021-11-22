package io.github.ailtonbsj.diospring.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Value("${app.message}")
    private String appMessage;

    @Value("${ENV_DB_URL:None}")
    private String dbEnviromentVariable;

    @GetMapping("/")
    public String hello(){
        return appMessage;
    }

    @GetMapping("/env")
    public String getDbEnviromentVariable(){
        return dbEnviromentVariable;
    }
}
