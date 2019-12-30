package com.aurel.lms.model;

import com.aurel.lms.model.courseLesson.CourseLesson;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class Lesson extends AbstractAuditingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private int displayOrder;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Column
    private Date attendanceStartAt;

    @Column
    private Date attendanceEndAt;

    @OneToMany(mappedBy = "lesson")
    private Set<GoalObjectives> goalObjectives;

    @OneToMany(mappedBy = "lesson")
    private Set<Attendance> attendances;

    @OneToMany(mappedBy = "lesson")
    private Set<CourseLesson> courses;

    @ManyToMany
    @JoinTable( name = "content_lesson",
                joinColumns = @JoinColumn(name = "content_id", referencedColumnName = "id"),
                inverseJoinColumns = @JoinColumn(name = "lesson_id", referencedColumnName = "id"))
    private Set<Content> contents;
}
