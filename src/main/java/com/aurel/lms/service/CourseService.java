package com.aurel.lms.service;

import com.aurel.lms.model.course.Course;
import com.aurel.lms.repository.CourseRepository;
import com.aurel.lms.security.UserPrincipal;
import com.aurel.lms.service.dto.request.course.CreateCourseRequest;
import com.aurel.lms.service.dto.response.ARConstants;
import com.aurel.lms.service.dto.response.ApiResponse;
import com.aurel.lms.service.mapper.CourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CourseService {

    private CourseRepository courseRepository;
    private CourseMapper courseMapper;

    @Autowired
    public CourseService(CourseRepository courseRepository, CourseMapper courseMapper) {

        this.courseRepository = courseRepository;
        this.courseMapper = courseMapper;
    }

    public ResponseEntity<?> newCourse(UserPrincipal principal, CreateCourseRequest request) {

        Course course = courseMapper.createCourseRequestToCourse(request);

        System.out.println(request);
        System.out.println(course);

        course = courseRepository.save(course);

        Map<String, Course> map = new HashMap<>();
        map.put("course", course);

        return new ResponseEntity<>(new ApiResponse(ARConstants.success, map), HttpStatus.OK);
    }
}
