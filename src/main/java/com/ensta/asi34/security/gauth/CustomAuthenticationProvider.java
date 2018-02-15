/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensta.asi34.security.gauth;

import com.ensta.asi34.model.User;
import com.ensta.asi34.model.repository.UserRepository;
import org.jboss.aerogear.security.otp.Totp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;

/**
 * @author trident
 */
public class CustomAuthenticationProvider extends DaoAuthenticationProvider {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Authentication authenticate(Authentication auth) {
        CustomWebAuthenticationDetails details = (CustomWebAuthenticationDetails) auth.getDetails();
        User user = userRepository.findByUsername(auth.getName());

        if (user == null) {
            throw new BadCredentialsException("Invalid username or password");
        }

        if (!user.getPassword().equals(auth.getCredentials().toString()))
            throw new BadCredentialsException("Invalid username or password");

        //todo check if GA is turned on
        Totp totp = new Totp(user.getgAuthSecret());
        if (!isValidLong(details.getVerificationCode()) || !totp.verify(details.getVerificationCode())) {
            throw new BadCredentialsException("Invalid verfication code");
        }
        //
        
        return new UsernamePasswordAuthenticationToken(
                user, auth.getCredentials(), auth.getAuthorities());
    }

    private boolean isValidLong(String code) {
        try {
            Long.parseLong(code);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
