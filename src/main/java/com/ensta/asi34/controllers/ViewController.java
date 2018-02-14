/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensta.asi34.controllers;

import com.ensta.asi34.model.User;
import com.ensta.asi34.model.repository.UserRepository;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author trident
 */
@Controller
public class ViewController {
    
    public static String QR_PREFIX = "https://chart.googleapis.com/chart?chs=200x200&chld=M%%7C0&cht=qr&chl=";
    public static String APP_NAME = "ENSTA Ldap";

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
    
    @GetMapping("/googleAuthenticatorQRCode")
    public String googleAuthenticatorQRCode(Model model) throws UnsupportedEncodingException{
        model.addAttribute("qr", generateQRUrl((User)model.asMap().get("loggedUser")));
        return "google_qr";
    }
    
 
    private String generateQRUrl(User user) throws UnsupportedEncodingException{
        return QR_PREFIX + URLEncoder.encode(String.format(
          "otpauth://totp/%s:%s?secret=%s&issuer=%s", 
          APP_NAME, user.getMail(), user.getgAuthSecret(), APP_NAME),"UTF-8");
    }
    
    

    @GetMapping("/add")
    public String add() {
        User user = new User();
        user.setUsername("michal");
        user.setQuestion("q");
        user.setName("name");
        user.setSurname("surname");
        user.setAnswer("a");
        user = repository.save(user);
        System.out.println(user);
        return "index";
    }

}
