package com.ensta.asi34.controllers;

import com.ensta.asi34.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author trident
 */
@Controller
public class ViewController {

    @Autowired
    UserRepository repository;

    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }

    @GetMapping("/userSettings")
    public String userSettings() {
        return "user_settings";
    }
}
