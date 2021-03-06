package com.aurel.lms.model.lesson;

import com.aurel.lms.model.*;
import com.aurel.lms.model.course.Course;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
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

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private LessonType type;

    @Column(nullable = false)
    private Date attendanceStartAt;

    @Column(nullable = false)
    private Date attendanceEndAt;

    @OneToMany(mappedBy = "lesson")
    private Set<GoalObjectives> goalObjectives;

    @OneToMany(mappedBy = "lesson")
    private Set<Attendance> attendances;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @ManyToMany
    @JoinTable( name = "content_lesson",
                joinColumns = @JoinColumn(name = "content_id", referencedColumnName = "id"),
                inverseJoinColumns = @JoinColumn(name = "lesson_id", referencedColumnName = "id"))
    private Set<Content> contents;

    public Lesson() {

        this.status = Status.DRAFT;
        this.type = LessonType.CLOSED;

        this.attendances = new HashSet<>();
        this.goalObjectives = new HashSet<>();
        this.contents = new HashSet<>();
    }
}
