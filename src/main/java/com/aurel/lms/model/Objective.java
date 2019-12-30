package com.aurel.lms.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class Objective extends AbstractAuditingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

    private String criteria;

    private int allocation;

    @ManyToOne
    @JoinColumn(name = "content_id")
    private Content content;

    @ManyToMany
    @JoinTable( name = "goalobjectives_objective",
            joinColumns = @JoinColumn(name = "goalobjective_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "objective_id", referencedColumnName = "id"))
    private Set<GoalObjectives> goalObjectives;
}
