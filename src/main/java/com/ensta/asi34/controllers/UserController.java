package com.ensta.asi34.controllers;

import com.ensta.asi34.model.User;
import com.ensta.asi34.model.dto.UserInfoDTO;
import com.ensta.asi34.model.dto.UserPassDTO;
import com.ensta.asi34.model.repository.UserRepository;
import com.ensta.asi34.security.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    UserRepository repository;

    @Autowired
    SecurityService securityService;

    @PostMapping(path = "/changeInfo")
    public String changeInfo(Model model, UserInfoDTO userInfo) {
        User user = securityService.findLoggedInUser();
        user.setName(userInfo.getName());
        user.setSurname(userInfo.getSurname());
        user.setMail(userInfo.getMail());
        repository.save(user);
        return "redirect:/userSettings";
    }

    @PostMapping(path = "/changePass")
    public String changePass(UserPassDTO userPass) {
        User user = securityService.findLoggedInUser();
        if (userPass.getPassword() != null)
            user.setPassword(userPass.getPassword());
        user.setQuestion(userPass.getQuestion());
        user.setAnswer(userPass.getAnswer());
        repository.save(user);
        return "redirect:/userSettings";
    }

    @GetMapping(path = "/passwordRemind")
    public String passwordRemind(Model model, @RequestParam(required = false) String username, @RequestParam(required = false) String error) {
        if (username != null) {
            model.addAttribute("username", username);
            User user = repository.findByUsername(username);
            if (user != null) {
                model.addAttribute("question", user.getQuestion());
            }
        }

        if (error != null) {
            model.addAttribute("error", "");
        }

        return "passwordRemind/passwordRemind";
    }

    @PostMapping(path = "/passwordRemind")
    public String passwordRemindChange(Model model, @RequestParam String answer, @RequestParam String password, @RequestParam String username) {
        User user = repository.findByUsername(username);
        if (user != null && checkAnswer(user.getAnswer(), answer)) {
            user.setPassword(password);
            repository.save(user);
            model.addAttribute("username", username);
            return "passwordRemind/passwordChanged";
        }
        return "redirect:/passwordRemind?username=" + username + "&error";

    }


    private boolean checkAnswer(String expected, String given) {
        return expected.trim().toLowerCase().equals(given.trim().toLowerCase());
    }
    
    
}
