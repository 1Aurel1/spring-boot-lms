package com.aurel.lms.controller;

import com.aurel.lms.security.UserPrincipal;
import com.aurel.lms.service.CourseService;
import com.aurel.lms.service.dto.request.course.CreateCourseRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/course")
public class CourseController {

    private CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping
    @PreAuthorize("hasAuthority('USER')")
    public ResponseEntity<?> postCourse(
            @AuthenticationPrincipal UserPrincipal principal,
            @Valid @RequestBody CreateCourseRequest request){

        return courseService.newCourse(principal, request);
    }

}
