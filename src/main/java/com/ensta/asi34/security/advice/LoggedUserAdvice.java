package com.ensta.asi34.security.advice;

import com.ensta.asi34.model.User;
import com.ensta.asi34.security.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class LoggedUserAdvice {
    @Autowired
    SecurityService securityService;


    @ModelAttribute("loggedUser")
    public User getLoggedUser() {
        return securityService.findLoggedInUser();
    }

}
