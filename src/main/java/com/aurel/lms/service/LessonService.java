package com.aurel.lms.service;

import com.aurel.lms.model.lesson.Lesson;
import com.aurel.lms.repository.LessonRepository;
import com.aurel.lms.security.UserPrincipal;
import com.aurel.lms.service.dto.request.CreateLessonRequest;
import com.aurel.lms.service.dto.response.ARConstants;
import com.aurel.lms.service.dto.response.ApiResponse;
import com.aurel.lms.service.dto.response.LessonDTO;
import com.aurel.lms.service.mapper.LessonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LessonService {

    private LessonRepository lessonRepository;

    @Autowired
    public LessonService(LessonRepository lessonRepository) {

        this.lessonRepository = lessonRepository;
    }

    public ResponseEntity<?> createLesson(UserPrincipal principal, CreateLessonRequest request){

        Lesson lesson = LessonMapper.createLessonRequestToLesson(request);

        if (lesson.getAttendanceStartAt().compareTo(lesson.getAttendanceEndAt()) < 0 ){
            LessonDTO lessonDTO = new LessonDTO(lessonRepository.save(lesson));
            Map<String, LessonDTO> data = new HashMap<>();
            data.put("lesson", lessonDTO);

            return new ResponseEntity<>(new ApiResponse(ARConstants.success, data), HttpStatus.CREATED);
        } else {

            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
