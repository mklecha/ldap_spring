package com.ensta.asi34.controllers;

import com.ensta.asi34.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Controller
public class QRController {

    public static String QR_PREFIX = "https://chart.googleapis.com/chart?chs=200x200&chld=M%%7C0&cht=qr&chl=";
    public static String APP_NAME = "ENSTA Ldap";

    @GetMapping("/googleAuthentication")
    public String googleAuthenticatorQRCode(Model model) throws UnsupportedEncodingException {
        model.addAttribute("qr", generateQRUrl((User) model.asMap().get("loggedUser")));
        return "google_qr";
    }


    private String generateQRUrl(User user) throws UnsupportedEncodingException {
        return QR_PREFIX + URLEncoder.encode(String.format(
                "otpauth://totp/%s:%s?secret=%s&issuer=%s",
                APP_NAME, user.getMail(), user.getgAuthSecret(), APP_NAME), "UTF-8");
    }

}
