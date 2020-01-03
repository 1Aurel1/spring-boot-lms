package com.aurel.lms.service.dto.response;

import com.aurel.lms.model.Objective;
import lombok.Data;

@Data
public class ObjectiveDTO {

    private int id;
    private String title;
    private String criteria;
    private int allocation;
    private int contentId;

    public ObjectiveDTO(Objective objective) {

        this.id = objective.getId();
        this.title = objective.getTitle();
        this.criteria = objective.getCriteria();
        this.allocation = objective.getAllocation();
        this.contentId = objective.getContent().getId();
    }
}
