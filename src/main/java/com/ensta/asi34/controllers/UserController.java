package com.ensta.asi34.controllers;

import com.ensta.asi34.data.UserInfoDTO;
import com.ensta.asi34.data.UserPassDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @PostMapping(path = "/changeInfo")
    public String changeInfo(UserInfoDTO userInfo) {
        System.out.println("Update name to " + userInfo.getName() + ", surname to " + userInfo.getSurname() + ", mail to " + userInfo.getMail());

        return "redirect:/";
    }

    @PostMapping(path = "/changePass")
    public String changePass(UserPassDTO userPass) {
        System.out.println("Update password to " + userPass.getPassword() + ", question to " + userPass.getQuestion() + ", answer to " + userPass.getAnswer());

        return "redirect:/";
    }

    @GetMapping(path = "/passwordRemind")
    public String passwordRemind(Model model, @RequestParam(required = false) String username) {
        if (username != null) {
            //get user question
            String question = "";
            model.addAttribute("question", question);
            model.addAttribute("username", username);
        }

        return "passwordRemind/passwordRemind";
    }

    @PostMapping(path = "/passwordRemind")
    public String passwordRemindChange(Model model, @RequestParam String answer, @RequestParam String password) {
        if (answer.equals("")) {//check answer here
            //change password here
        } else {
            model.addAttribute("error", "");
        }
        return "passwordRemind/passwordChanged";
    }
}
