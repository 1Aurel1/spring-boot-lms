package com.aurel.lms.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class GoalObjectives extends AbstractAuditingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn
    private Goal goal;

    @ManyToOne
    @JoinColumn(name = "lesson_id")
    private Lesson lesson;

    @ManyToMany
    @JoinTable( name = "goalobjectives_objective",
            joinColumns = @JoinColumn(name = "objective_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "goalobjective_id", referencedColumnName = "id"))
    private Set<Objective> objectives;
}
