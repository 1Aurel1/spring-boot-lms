package com.aurel.lms.service.dto.request.term;

import lombok.Data;

import java.util.Set;

@Data
public class CreateTermRequest {

    private String title;
    private String startAt;
    private String endAt;
    private String guid;
    private Set<Integer> courses;
}
