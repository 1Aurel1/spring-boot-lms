package com.aurel.lms.model;

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
public class Term extends AbstractAuditingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String title;

    @Column
    private Date startAt;

    @Column
    private Date endAt;

    @Column
    private String guid;

    @OneToMany(mappedBy = "term")
    Set<Course> courses;

    public Term() {
        courses = new HashSet<>();
    }

    public void addCourse(Course course){
        this.courses.add(course);
    }

    public void removeCourse(Course course){
        this.courses.remove(course);
    }
}
