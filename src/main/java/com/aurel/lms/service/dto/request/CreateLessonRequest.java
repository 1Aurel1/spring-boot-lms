package com.aurel.lms.service.dto.request;

import lombok.Data;

@Data
public class CreateLessonRequest {

    private String attendanceStartAt;
    private String attendanceEndAt;

}
