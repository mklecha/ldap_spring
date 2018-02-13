package com.ensta.asi34.security.service;

import com.ensta.asi34.model.User;

public interface SecurityService {
    User findLoggedInUser();
}
