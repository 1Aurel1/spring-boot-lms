package com.aurel.lms.model;

import com.aurel.lms.model.courseLesson.CourseLesson;
import com.aurel.lms.model.courseUser.CourseUser;
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

    @Enumerated(EnumType.STRING)
    private Status status;

    @Column
    private int groupCount;

    @Column
    private int weekDay;

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
    private Set<CourseLesson> lessons;

    //TODO outcomes, notes
}
