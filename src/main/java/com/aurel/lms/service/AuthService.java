package com.aurel.lms.service;

import com.aurel.lms.service.dto.response.UserDTO;
import com.aurel.lms.service.dto.response.ARConstants;
import com.aurel.lms.service.dto.request.auth.UserAuthenticationRequest;
import com.aurel.lms.service.dto.request.auth.UserRegistrationRequest;
import com.aurel.lms.service.dto.response.ApiResponse;
import com.aurel.lms.exeption.ResourceNotFoundException;
import com.aurel.lms.model.User;
import com.aurel.lms.model.authority.AuthorityName;
import com.aurel.lms.repository.AuthorityRepository;
import com.aurel.lms.repository.UserRepository;
import com.aurel.lms.security.JWTProvider;
import com.aurel.lms.service.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthService {

    private UserRepository userRepository;
    private AuthorityRepository authorityRepository;
    private AuthenticationManager authenticationManager;
    private JWTProvider jwtProvider;
    private PasswordEncoder passwordEncoder;
    private UserMapper userMapper;

    @Autowired
    public AuthService(UserRepository userRepository, AuthorityRepository authorityRepository, AuthenticationManager authenticationManager, JWTProvider jwtProvider, PasswordEncoder passwordEncoder, UserMapper userMapper) {

        this.userRepository = userRepository;
        this.authorityRepository = authorityRepository;
        this.authenticationManager = authenticationManager;
        this.jwtProvider = jwtProvider;
        this.passwordEncoder = passwordEncoder;
        this.userMapper = userMapper;
    }

    public ResponseEntity<?> registerUser(UserRegistrationRequest request){

        User user = userMapper.userRegistrationRequestToUser(request);

        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.addAuthority(authorityRepository.findByName(AuthorityName.USER).orElseThrow(() -> new ResourceNotFoundException("Authority", "name", AuthorityName.USER.toString())));


        user = userRepository.save(user);

        UserDTO userDTO = new UserDTO(user);
        Map<String, UserDTO> data = new HashMap<>();
        data.put("user", userDTO);

        return new ResponseEntity<>(new ApiResponse(ARConstants.success, data), HttpStatus.OK);
    }

    public ResponseEntity<?> authenticateUser(UserAuthenticationRequest authRequest) throws Exception {

        System.out.println(authRequest);

        Authentication authentication = authenticate(authRequest.getUsername(), authRequest.getPassword());

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtProvider.generateToken(authentication);

        Map<String, String> data = new HashMap<>();
        data.put("Token Type", "Bearer");
        data.put("JWT", jwt);

        return new ResponseEntity<>(new ApiResponse(ARConstants.success, data), HttpStatus.OK);
    }

    private Authentication authenticate(String username, String password) throws Exception {

        try {

            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {

            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {

            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }

}
