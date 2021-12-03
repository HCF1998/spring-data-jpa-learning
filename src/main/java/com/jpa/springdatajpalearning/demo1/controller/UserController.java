package com.jpa.springdatajpalearning.demo1.controller;

import com.jpa.springdatajpalearning.demo1.entity.User;
import com.jpa.springdatajpalearning.demo1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/demo01")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/addUser")
    public void addUser(@RequestParam String name, @RequestParam String email) {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        userRepository.save(user);
    }
    @GetMapping("/all")
    public Iterable<User> getAllUser(){
        return userRepository.findAll();
    }
}
