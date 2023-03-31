package com.todotracker.user.model;

import com.todotracker.utils.statuses.Roles;
import com.todotracker.utils.statuses.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserRegistrationRequest {
    private Integer userId;
    private String firstName;
    private String lastName;
    private String email;
    private Roles userRole;
    private UserStatus userStatus;

}
