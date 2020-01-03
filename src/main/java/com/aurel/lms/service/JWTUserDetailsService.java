package com.aurel.lms.service;

import com.aurel.lms.model.User;
import com.aurel.lms.repository.UserRepository;
import com.aurel.lms.security.UserPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JWTUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    public JWTUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(String.format("User not found with this username or email: %s", username)));
        return UserPrincipal.create(user);
    }
}
