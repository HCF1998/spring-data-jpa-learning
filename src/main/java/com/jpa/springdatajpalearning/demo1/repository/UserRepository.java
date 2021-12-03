package com.jpa.springdatajpalearning.demo1.repository;

import com.jpa.springdatajpalearning.demo1.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {
}
