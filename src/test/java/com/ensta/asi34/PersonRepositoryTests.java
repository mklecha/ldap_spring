/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensta.asi34;

import com.ensta.asi34.model.User;
import com.ensta.asi34.model.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author trident
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class PersonRepositoryTests {

    @Autowired
    UserRepository repository;

    @Test
    public void readAll() {

      Iterable<User> persons = repository.findAll();
      for(User u:persons){
          System.out.println(u);
      }
      Assert.assertTrue(true);
    }
}
