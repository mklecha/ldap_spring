/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensta.asi34.controllers;

import com.ensta.asi34.model.User;
import com.ensta.asi34.model.repository.UserRepository;
import com.ensta.asi34.security.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author trident
 */
@Controller
public class ViewController {

    @Autowired
    UserRepository repository;

    @Autowired
    SecurityService securityService;

    @GetMapping("/")
    public String index() {
        return "index";
    }
    
    @GetMapping("/userSettings")
    public String userSettings() {
        return "user_settings";
    }
    
    

    @GetMapping("/add")
    public String add() {
        User user = new User();
        user.setUsername("michal");
        user.setQuestion("q");
        user.setSurname("surname");
        user.setAnswer("a");
        user = repository.save(user);
        System.out.println(user);
        return "index";
    }

}
