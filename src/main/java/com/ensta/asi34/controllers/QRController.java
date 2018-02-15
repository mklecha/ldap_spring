package com.ensta.asi34.controllers;

import com.ensta.asi34.model.User;
import com.ensta.asi34.security.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Controller
public class QRController {

    public static String QR_PREFIX = "https://chart.googleapis.com/chart?chs=200x200&chld=M%%7C0&cht=qr&chl=";
    public static String APP_NAME = "ENSTA Ldap";

    @Autowired
    private SecurityService securityService;

    @GetMapping("/googleAuthentication")
    public String googleAuthenticatorQRCode(Model model) throws UnsupportedEncodingException {
        User loggedUser = securityService.findLoggedInUser();
        model.addAttribute("qr", generateQRUrl(loggedUser));
        return "google_qr";
    }


    private String generateQRUrl(User user) throws UnsupportedEncodingException {
        String url = String.format("otpauth://totp/%s:%s?secret=%s&issuer=%s", APP_NAME, user.getMail(), user.getgAuthSecret(), APP_NAME);
        return QR_PREFIX + URLEncoder.encode(url, "UTF-8");
    }

}
