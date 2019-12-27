package com.aurel.lms.model;

import com.aurel.lms.model.file.ImageFile;
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

    @OneToOne
    @JoinColumn
    private ImageFile image;

    @ManyToOne
    @JoinColumn
    private Term term;

    @OneToMany(mappedBy = "course")
    private Set<Goal> goals;

    @OneToMany(mappedBy = "course")
    private Set<Notice> notices;

    @ManyToMany
    @JoinTable(name = "course_manager")
    private Set<User> managers;

    @ManyToMany
    @JoinTable
    private Set<User> assistants;

    @ManyToMany
    @JoinTable
    private Set<User> learners;

    @ManyToMany
    @JoinTable
    private Set<Content> contents;

    @ManyToMany
    @JoinTable
    private Set<Lesson> lessons;

    @ManyToMany
    @JoinTable
    private Set<Lesson> openLessons;

    //TODO outcomes, notes
}
