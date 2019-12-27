package com.aurel.lms.dto.request.auth;

import lombok.Data;

@Data
public class UserRegistrationRequest {

    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String password;
}
