package com.aurel.lms.service.dto.request.term;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Set;

@Data
public class CreateTermRequest {

    @NotNull
    @NotEmpty
    @Size(min = 3)
    private String title;

    @NotNull
    @NotEmpty
    @Pattern(regexp = "^([0-2][0-9]|(3)[0-1])(/)(((0)[0-9])|((1)[0-2]))(/)\\d{4}$", message = "")
    private String startAt;

    @NotNull
    @NotEmpty
    @Pattern(regexp = "^([0-2][0-9]|(3)[0-1])(/)(((0)[0-9])|((1)[0-2]))(/)\\d{4}$", message = "")
    private String endAt;

    private String guid;

    private Set<Integer> courses;
}
