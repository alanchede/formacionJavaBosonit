package com.bosonit.block6pathvariableheaders.User.Controller;

import com.bosonit.block6pathvariableheaders.User.Model.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    private final List<User> users = new ArrayList<>();

    @PostMapping("/user")
    public String newUser(@RequestBody User user) {
        users.add(user);
        return "Added user: id = " + user.getId() + " name = " + user.getName();
    }

    @GetMapping("/user/{id}")
    public String getUser(@PathVariable int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return "User: id = " + user.getId() + " name = " + user.getName();
            }
        }
        return "User id not found";
    }

    @PutMapping("/post")
    public String updateUser(@RequestParam int id, @RequestParam String name) {
        for (User user : users) {
            if (user.getId() == id) {
                String oldName = user.getName();
                user.setName(name);
                return "User with id " + user.getId() + " updated: old name = " + oldName + ", new name = " + user.getName();
            }
        }
        return "User id not found";
    }
}
