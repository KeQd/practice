package com.example.practice.controller;

import com.example.practice.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ArrayList;

@RestController
@RequestMapping("/api")
public class UserController {

    private List<User> users = new ArrayList<>();

    @GetMapping
    public List<User> getAllUsers() {
        return users;
    }

    @GetMapping("/adduser/{id}/{name}/{email}")
    public User addUser(@PathVariable int id, @PathVariable String name, @PathVariable String email) {
        User user = new User(id, name, email);
        users.add(user);
        return user;
    }

    @GetMapping("/delete/{id}")
    public void deleteUser(@PathVariable int id) {
        users.removeIf(user -> user.getId() == id);
    }

    @GetMapping("/change/{id}/{name}/{email}")
    public User changeUserData(@PathVariable int id, @PathVariable String name, @PathVariable String email) {
        for (User user : users) {
            if (user.getId() == id) {
                user.setName(name);
                user.setEmail(email);
                return user;
            }
        }
        return null;
    }

    @GetMapping("/get-user-info")
    public User getUserInfo(@RequestParam int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }
}
