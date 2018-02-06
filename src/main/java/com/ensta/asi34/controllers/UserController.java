package com.ensta.asi34.controllers;

import com.ensta.asi34.data.UserInfoDTO;
import com.ensta.asi34.data.UserPassDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

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
}
