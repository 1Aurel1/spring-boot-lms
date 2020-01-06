package com.aurel.lms.model.course;

import com.aurel.lms.model.*;
import com.aurel.lms.model.courseUser.CourseUser;
import com.aurel.lms.model.file.ImageFile;
import com.aurel.lms.model.lesson.Lesson;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class Course extends AbstractAuditingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NaturalId
    @Column(length = 124, nullable = false)
    private String title;

    @Column
    private String overview;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Column
    private int groupCount;

    @Column
    @Enumerated(EnumType.STRING)
    private WeekDay weekDay;

    @Column
    private int period;

    @Column
    private boolean enabled;

    @OneToOne
    @JoinColumn(name = "image_id")
    private ImageFile image;

    @ManyToOne
    @JoinColumn(name = "term_id")
    private Term term;

    @OneToMany(mappedBy = "course")
    private Set<Goal> goals;

    @OneToMany(mappedBy = "course")
    private Set<Notice> notices;

    @OneToMany(mappedBy = "course")
    private Set<CourseUser> users;

    @OneToMany(mappedBy = "course")
    private Set<Lesson> lessons;

    //TODO outcomes, notes


    public Course() {

        this.goals = new HashSet<>();
        this.notices = new HashSet<>();
        this.users = new HashSet<>();
        this.lessons = new HashSet<>();
    }
}
