package com.example.swaggerdemo.controller;


import com.example.swaggerdemo.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private List<User> userList = new ArrayList<>();

    @GetMapping
    public List<User> getAllUsers() {
        return userList;
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id) {
        for (User user : userList) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    @PostMapping
    public String addUser(@RequestBody User user) {
        userList.add(user);
        return "User added successfully";
    }


}
