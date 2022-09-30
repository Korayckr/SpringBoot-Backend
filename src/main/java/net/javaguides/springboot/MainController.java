package net.javaguides.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping("/mainPage")
    public String goodbye() {
        return "mainPage.html";
    }

}
