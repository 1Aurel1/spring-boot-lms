package com.aurel.lms.model;

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

    @Column
    private String status;

    @Column
    private Date attendanceStartAt;

    @Column
    private Date attendanceEndAt;

    @ManyToMany
    private Set<Course> courses;
}
