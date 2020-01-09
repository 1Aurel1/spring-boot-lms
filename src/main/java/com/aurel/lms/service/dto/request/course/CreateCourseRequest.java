package com.aurel.lms.service.dto.request.course;

import com.aurel.lms.model.course.WeekDay;
import com.aurel.lms.validator.valOfEnum.ValueOfEnum;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Data
public class CreateCourseRequest {

    @NotEmpty
    @NotNull
    @Size(min = 3)
    private String title;

    @NotEmpty
    @NotNull
    @Size(min = 5)
    private String overview;

    private String status;

    @ValueOfEnum(enumClass = WeekDay.class)
    private String weekDay;

    private int period;
    private boolean enabled;

    private int termID;

    @Size(min = 1)
    private String[] goals;

    private Set<CourseUserDTO> users;
}
