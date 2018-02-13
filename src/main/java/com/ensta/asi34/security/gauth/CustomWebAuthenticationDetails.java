/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensta.asi34.security.gauth;

import javax.servlet.http.HttpServletRequest;
import org.springframework.security.web.authentication.WebAuthenticationDetails;

/**
 *
 * @author trident
 */
public class CustomWebAuthenticationDetails extends WebAuthenticationDetails {
 
    private String verificationCode;
 
    public CustomWebAuthenticationDetails(HttpServletRequest request) {
        super(request);
        verificationCode = request.getParameter("code");
    }
 
    public String getVerificationCode() {
        return verificationCode;
    }
    
}