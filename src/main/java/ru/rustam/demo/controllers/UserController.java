package ru.rustam.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.rustam.demo.model.User;
import ru.rustam.demo.service.UserService;

import java.util.List;

@Controller
public class UserController {


    @Autowired
    private UserService userService;

    @GetMapping(value = "/users", produces = "Application/json")
    public ResponseEntity users() {
        List<User> list = userService.getAll();
        list.forEach(user -> user.setPassword(null));
        return ResponseEntity.ok(list);
    }

    @RequestMapping(value = "/user/add", method = RequestMethod.POST)
    public ResponseEntity addUser(@RequestBody User user) {
        User userCheck = userService.findUserByUsername(user.getUsername());
        if (userCheck == null) {
            userService.saveUser(user);
            return ResponseEntity.ok(user);
        } else return ResponseEntity.ok("User with this username was already exist.");
    }
}
