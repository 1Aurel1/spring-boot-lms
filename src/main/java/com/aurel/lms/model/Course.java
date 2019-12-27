package com.aurel.lms.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class Course extends AbstractAuditingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String title;

    @Column
    private String overview;

    @Column
    private String status;

    @Column
    private int groupCount;

    @Column
    private int weekDay;

    @Column
    private int period;

    @Column
    private boolean enabled;

    @ManyToOne
    private Term term;

    @ManyToMany
    private Set<User> managers;

    @ManyToMany
    private Set<User> assistants;

    @ManyToMany
    private Set<User> learners;

    @ManyToMany
    private Set<Lesson> lessons;


}
