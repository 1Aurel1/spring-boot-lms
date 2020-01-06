package com.aurel.lms.service.mapper;

import com.aurel.lms.model.lesson.Lesson;
import com.aurel.lms.model.Status;
import com.aurel.lms.service.dto.request.CreateLessonRequest;
import com.aurel.lms.util.DateUtil;

public class LessonMapper {

    public static Lesson createLessonRequestToLesson(CreateLessonRequest request){

        Lesson lesson = new Lesson();

        lesson.setAttendanceStartAt(DateUtil.format1ToDate(request.getAttendanceStartAt()));
        lesson.setAttendanceEndAt(DateUtil.format1ToDate(request.getAttendanceEndAt()));
        lesson.setStatus(Status.valueOf(request.getStatus()));

        return lesson;
    }
}
