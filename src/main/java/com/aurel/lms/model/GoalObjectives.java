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
    @JoinColumn
    private Lesson lesson;

    @ManyToMany
    @JoinTable
    private Set<Objective> objectives;
}
