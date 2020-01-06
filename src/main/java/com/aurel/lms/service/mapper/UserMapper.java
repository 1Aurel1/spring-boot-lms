package com.aurel.lms.service.mapper;

import com.aurel.lms.exeption.ResourceNotFoundException;
import com.aurel.lms.model.User;
import com.aurel.lms.model.courseUser.CourseUser;
import com.aurel.lms.model.courseUser.CourseUserType;
import com.aurel.lms.repository.UserRepository;
import com.aurel.lms.service.dto.request.auth.UserRegistrationRequest;
import com.aurel.lms.service.dto.request.course.CourseUserDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {

    private UserRepository userRepository;

    @Autowired
    public UserMapper(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User userRegistrationRequestToUser(UserRegistrationRequest request){

        User user = new User();
        BeanUtils.copyProperties(request, user);

        user.setEnabled(true);
        user.setAccountNonExpired(true);
        user.setAccountNonLocked(true);
        user.setCredentialsNonExpired(true);


        return user;
    }

    public CourseUser courseUserDtoTOUser(CourseUserDTO dto){

        CourseUser user = new CourseUser();
        user.setUser(userRepository.getById(dto.getUserID()).orElseThrow(()-> new ResourceNotFoundException("User", "Id", dto.getUserID())));
        user.setType(CourseUserType.valueOf(dto.getType()));

        return user;
    }

}
