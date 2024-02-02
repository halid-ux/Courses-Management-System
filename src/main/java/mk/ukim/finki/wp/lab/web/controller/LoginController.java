package mk.ukim.finki.wp.lab.web.controller;

import org.springframework.web.bind.annotation.GetMapping;

//@Controller
//@RequestMapping("/login")
public class LoginController {
    @GetMapping()
    public String login()
    {
        return "login";
    }
}
