package com.aurel.lms.model;

import com.aurel.lms.model.course.Course;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@Table( uniqueConstraints = {
        @UniqueConstraint(
                name = "uk_course_title",
                columnNames = {"course_id", "title"}
        )}
)
public class Goal extends AbstractAuditingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String title;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
}