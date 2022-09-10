package br.ailtonbsj.filterexample;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @RequestMapping("/home")
    public String getHome() {
        System.out.println("Home controller");
        return "home";
    }

    @RequestMapping("/second")
    public String getSecond() {
        System.out.println("Second controller");
        return "second";
    }
}
