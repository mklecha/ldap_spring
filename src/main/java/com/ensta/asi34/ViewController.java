/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensta.asi34;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author trident
 */
@RestController
public class ViewController {
    @GetMapping("/")
    public String index() {
        return "Welcome to the home page!";
    }
}
