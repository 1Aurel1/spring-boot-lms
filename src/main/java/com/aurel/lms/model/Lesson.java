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

    @Enumerated(EnumType.STRING)
    private Status status;

    @Column
    private Date attendanceStartAt;

    @Column
    private Date attendanceEndAt;

    @OneToMany(mappedBy = "lesson")
    private Set<Attendance> attendances;

    @ManyToMany
    @JoinTable
    private Set<Course> courses;
}
