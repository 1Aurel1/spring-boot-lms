package com.aurel.lms.service.dto.request.course;

import com.aurel.lms.model.courseUser.CourseUserType;
import com.aurel.lms.validator.valOfEnum.ValueOfEnum;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class CourseUserDTO {

    @NotNull
    private int userID;

    @NotEmpty
    @NotNull
    @ValueOfEnum(enumClass = CourseUserType.class)
    private String type;
}
