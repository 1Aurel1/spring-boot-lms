package com.aurel.lms.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;
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
}
