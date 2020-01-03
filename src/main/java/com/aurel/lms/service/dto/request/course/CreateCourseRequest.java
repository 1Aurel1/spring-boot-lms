package com.aurel.lms.service.dto.request.course;

import lombok.Data;

@Data
public class CreateCourseRequest {

    private String title;
    private String overview;
    private String status;
    private String weekDay;
    private int period;
    private boolean enabled;
}
