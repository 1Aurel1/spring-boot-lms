package com.aurel.lms.service.dto.response;

import com.aurel.lms.model.Goal;
import lombok.Data;

@Data
public class GoalDTO {

    private int id;
    private String title;

    public GoalDTO(Goal goal) {

        this.id = goal.getId();
        this.title = goal.getTitle();
    }
}