package com.ensta.asi34;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @RequestMapping(path="/login")
    public String login(){
        return "login";
    }
}