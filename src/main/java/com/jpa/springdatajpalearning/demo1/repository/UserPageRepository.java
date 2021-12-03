package com.jpa.springdatajpalearning.demo1.repository;

import com.jpa.springdatajpalearning.demo1.entity.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserPageRepository extends PagingAndSortingRepository<User,Long> {
}
