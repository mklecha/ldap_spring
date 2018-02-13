package com.ensta.asi34.model.repository;

import com.ensta.asi34.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.naming.Name;

@Repository
public interface UserRepository extends CrudRepository<User, Name> {
    User findByUsername(String username);
}
