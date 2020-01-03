package com.aurel.lms.service.dto.response;

import com.aurel.lms.model.User;
import lombok.Data;

@Data
public class UserDTO {

    private String firstName;
    private String lastName;
    private String username;
    private String email;

    public UserDTO(User user) {
        
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.username = user.getUsername();
        this.email = user.getEmail();
    }
}
