package com.jpa.springdatajpalearning.demo1.controller;

import com.jpa.springdatajpalearning.demo1.entity.User;
import com.jpa.springdatajpalearning.demo1.repository.UserCrudRepository;
import com.jpa.springdatajpalearning.demo1.repository.UserPageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/demo01")
public class UserController {

    @Autowired
    private UserCrudRepository userCrudRepository;
    @Autowired
    private UserPageRepository userPageRepository;

    @GetMapping("/addUser")
    public void addUser(@RequestParam String name, @RequestParam String email) {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        userCrudRepository.save(user);
    }

    @GetMapping("/all")
    public Iterable<User> getAllUser() {
        return userCrudRepository.findAll();
    }

    @GetMapping("/info")
    public User getOne(@RequestParam Long id) {
        return userCrudRepository.findById(id).get();
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam Long id) {
        userCrudRepository.deleteById(id);
    }

    @GetMapping("/page")
    public Page<User> getAllUserByPage() {
        Sort sort = Sort.by(Sort.Direction.ASC, "name");
        return userPageRepository.findAll(PageRequest.of(1, 20, sort));
    }

    @GetMapping("/sort")
    public Iterable<User> getAllUsersWithSort(){
        return userPageRepository.findAll(Sort.by(new Sort.Order(Sort.Direction.ASC,"name")));
    }
}
