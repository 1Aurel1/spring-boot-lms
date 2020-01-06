package com.aurel.lms.model;

import com.aurel.lms.model.lesson.Lesson;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(
    uniqueConstraints = {
        @UniqueConstraint(
            name = "UK_goal_lesson",
            columnNames = {"goal_id", "lesson_id"}
    )
})
public class GoalObjectives extends AbstractAuditingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "goal_id")
    private Goal goal;

    @ManyToOne
    @JoinColumn(name = "lesson_id")
    private Lesson lesson;

    @ManyToMany
    @JoinTable( name = "goalobjectives_objective",
            joinColumns = @JoinColumn(name = "objective_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "goalobjective_id", referencedColumnName = "id"))
    private Set<Objective> objectives;

    public GoalObjectives() {

        this.objectives = new HashSet<>();
    }
}