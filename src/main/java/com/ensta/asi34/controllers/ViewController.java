/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensta.asi34.controllers;

import com.ensta.asi34.model.User;
import com.ensta.asi34.model.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author trident
 */
@Controller
public class ViewController {

    @Autowired
    PersonRepository repository;

    @GetMapping("/")
    public String index() {
        Iterable<User> users = repository.findAll();
        for (User u : users) {
            System.out.println(u);
        }
        return "index";
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
