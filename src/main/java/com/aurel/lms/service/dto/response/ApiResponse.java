package com.aurel.lms.service.dto.response;

import lombok.Data;

import java.util.Map;

@Data
public class ApiResponse {

    private String status;
    private Map<String, ?> data;
}
