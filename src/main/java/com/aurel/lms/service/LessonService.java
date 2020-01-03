package com.aurel.lms.service;

import com.aurel.lms.repository.LessonRepository;
import com.aurel.lms.security.UserPrincipal;
import com.aurel.lms.service.dto.response.LessonDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class LessonService {

    private LessonRepository lessonRepository;

    @Autowired
    public LessonService(LessonRepository lessonRepository) {

        this.lessonRepository = lessonRepository;
    }

    public ResponseEntity<?> createLesson(UserPrincipal principal, ){


    }
}
