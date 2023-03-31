package com.todotracker.user.services;

import com.todotracker.user.model.User;
import com.todotracker.user.model.UserRegistrationRequest;
import com.todotracker.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void registerUser(UserRegistrationRequest request) {
        User user = User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                //ToDO: check of enum is valid
                .userRole(request.getUserRole())
                .userStatus(request.getUserStatus())
                .build();
        //ToDO: check if email valid and not taken
        userRepository.saveAndFlush(user);
    }

    public List<User> getAllUsers() {
        List<User> userList = userRepository.findAll();
        return userList;
    }

    public void updateUserById(User request) {
        User user = userRepository.getById(request.getUserId());
        if (user != null) {
            user.setFirstName(request.getFirstName());
            user.setEmail(request.getEmail());
            user.setLastName(request.getLastName());
        }
        userRepository.save(user);
    }
}
