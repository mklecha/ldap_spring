package com.ensta.asi34.security.service;

import com.ensta.asi34.model.User;
import com.ensta.asi34.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class SecurityServiceImp implements SecurityService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findLoggedInUser() {
        Object userDetails = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (userDetails instanceof User) {
            User u = (User) userDetails;
            return userRepository.findByUsername(u.getUsername());
        }
        return null;
    }
}