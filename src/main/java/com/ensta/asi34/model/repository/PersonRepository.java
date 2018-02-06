package com.ensta.asi34.model.repository;

import com.ensta.asi34.model.User;
import org.springframework.stereotype.Repository;

import org.springframework.data.repository.CrudRepository;

@Repository
public interface PersonRepository extends CrudRepository<User, Long> {
}
