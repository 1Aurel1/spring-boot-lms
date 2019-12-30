package com.aurel.lms.model.courseUser;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
public class CourseUserId implements Serializable {

    @Column
    private int courseId;

    @Column
    private int userId;
}
