package com.jpa.springdatajpalearning.demo1.repository;

import com.jpa.springdatajpalearning.demo1.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserCrudRepository extends CrudRepository<User,Long> {
}
