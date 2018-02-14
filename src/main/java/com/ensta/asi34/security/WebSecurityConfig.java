/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensta.asi34.security;

import com.ensta.asi34.security.gauth.CustomWebAuthenticationDetailsSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author trident
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    
    @Autowired
    private CustomWebAuthenticationDetailsSource authenticationDetailsSource;
    
    @Autowired
    DaoAuthenticationProvider provider;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().
                authorizeRequests()
                .antMatchers("/css/**", "/fonts/**", "/images/**", "/js/**", "/vendor/**", "/webjars/**").permitAll()
                .antMatchers("/passwordRemind").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .authenticationDetailsSource(authenticationDetailsSource)
                .loginPage("/login").permitAll()
                .and()
                .logout().logoutSuccessUrl("/login?logout")
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .permitAll();
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(provider);
    }
}