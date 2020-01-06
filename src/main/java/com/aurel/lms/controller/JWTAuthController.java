package com.aurel.lms.controller;

import com.aurel.lms.service.dto.request.auth.UserAuthenticationRequest;
import com.aurel.lms.service.dto.request.auth.UserRegistrationRequest;
import com.aurel.lms.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@CrossOrigin
public class JWTAuthController {

    private AuthService authService;

    @Autowired
    public JWTAuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/authenticate")
    public ResponseEntity<?> postAuth(@Valid @RequestBody UserAuthenticationRequest userAuthenticationRequest) throws Exception {

        return authService.authenticateUser(userAuthenticationRequest);
    }

    @PostMapping("/register")
    public ResponseEntity<?> postRegister(@Valid @RequestBody UserRegistrationRequest userRegistrationRequest){

        return authService.registerUser(userRegistrationRequest);
    }

}
