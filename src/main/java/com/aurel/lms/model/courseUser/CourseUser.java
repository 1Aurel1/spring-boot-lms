package com.aurel.lms.model.courseUser;

import com.aurel.lms.model.Course;
import com.aurel.lms.model.User;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class CourseUser {

    @EmbeddedId
    private CourseUserId id;

    @Enumerated(EnumType.ORDINAL)
    private CourseUserType type;

    @ManyToOne
    @MapsId("courseId")
    private Course course;

    @ManyToOne
    @MapsId("userId")
    private User user;
}
