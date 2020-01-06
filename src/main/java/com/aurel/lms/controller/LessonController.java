package com.aurel.lms.controller;

import com.aurel.lms.security.UserPrincipal;
import com.aurel.lms.service.LessonService;
import com.aurel.lms.service.dto.request.CreateLessonRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/lesson")
public class LessonController {

    private LessonService lessonService;

    @Autowired
    public LessonController(LessonService lessonService) {
        this.lessonService = lessonService;
    }

    @PreAuthorize("hasAnyAuthority('TEACHER','ADMIN')")
    @PostMapping
    public ResponseEntity<?> postLesson(
            @AuthenticationPrincipal UserPrincipal principal,
            @Valid @RequestBody CreateLessonRequest request){

        return lessonService.createLesson(principal, request);
    }
}
