package com.aurel.lms.service.dto.request.auth;

import lombok.Data;

@Data
public class UserAuthenticationRequest {

    private String username;
    private String password;
}
