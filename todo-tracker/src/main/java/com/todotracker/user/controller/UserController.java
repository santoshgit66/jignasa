package com.todotracker.user.controller;

import com.todotracker.user.model.User;
import com.todotracker.user.model.UserRegistrationRequest;
import com.todotracker.user.services.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/v1/users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public void registerUser(@RequestBody UserRegistrationRequest userRegistrationRequest) {
        log.info("new user registration {}", userRegistrationRequest);
        userService.registerUser(userRegistrationRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<User> getAllUsers() {
        List<User> allUsers = userService.getAllUsers();
        return allUsers;
    }

    @PutMapping(value = "/update")
    @ResponseStatus(HttpStatus.OK)
    public void updateUserById(@RequestBody User user) {
        userService.updateUserById(user);
    }
}
