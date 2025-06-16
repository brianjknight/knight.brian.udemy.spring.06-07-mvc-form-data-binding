package knight.brian.udemy.spring.thymeleafdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
@Controller
public class DemoController {

    @GetMapping("/hello")
    public String sayHello(Model model) {

        model.addAttribute("theDate", LocalDateTime.now());

        // Spring Boot auto-configures to return the helloworld.html template
        return "helloworld";
    }

}
