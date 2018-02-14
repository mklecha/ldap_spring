/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensta.asi34.security.gauth;

import javax.servlet.http.HttpServletRequest;
import org.springframework.security.authentication.AuthenticationDetailsSource;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;

/**
 *
 * @author trident
 */
@Component
public class CustomWebAuthenticationDetailsSource implements
  AuthenticationDetailsSource<HttpServletRequest, WebAuthenticationDetails> {
     
    @Override
    public WebAuthenticationDetails buildDetails(HttpServletRequest context) {
        return new CustomWebAuthenticationDetails(context);
    }
}
