package com.aurel.lms.service.dto.request;

import com.aurel.lms.model.Status;
import com.aurel.lms.validator.valOfEnum.ValueOfEnum;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
public class CreateLessonRequest {

    @NotNull
    @NotEmpty
    @Pattern(regexp = "^([0-2][0-9]|(3)[0-1])(/)(((0)[0-9])|((1)[0-2]))(/)\\d{4}$", message = "")
    private String attendanceStartAt;

    @NotNull
    @NotEmpty
    @Pattern(regexp = "^([0-2][0-9]|(3)[0-1])(/)(((0)[0-9])|((1)[0-2]))(/)\\d{4}$", message = "")
    private String attendanceEndAt;


    @NotNull
    @NotEmpty
    @ValueOfEnum(enumClass = Status.class)
    private String status;
}