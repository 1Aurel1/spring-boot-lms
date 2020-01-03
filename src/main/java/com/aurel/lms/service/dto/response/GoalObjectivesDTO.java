package com.aurel.lms.service.dto.response;

import com.aurel.lms.model.Goal;
import com.aurel.lms.model.GoalObjectives;
import com.aurel.lms.model.Objective;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class GoalObjectivesDTO {

    private int id;
    private String goalTitle;
    private Set<ObjectiveDTO> objectives;

    public GoalObjectivesDTO(GoalObjectives goalObjectives) {
        this.id = goalObjectives.getId();
        this.goalTitle = goalObjectives.getGoal().getTitle();

        this.objectives = new HashSet<>();
        for (Objective objective: goalObjectives.getObjectives()){
            this.objectives.add(new ObjectiveDTO(objective));
        }
    }
}
