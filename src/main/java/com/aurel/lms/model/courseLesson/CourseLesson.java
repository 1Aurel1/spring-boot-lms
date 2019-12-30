package com.aurel.lms.model.courseLesson;

import com.aurel.lms.model.Course;
import com.aurel.lms.model.Lesson;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class CourseLesson {

    @EmbeddedId
    private CourseLessonId id;

    @Enumerated(EnumType.ORDINAL)
    private CourseLessonType type;

    @ManyToOne
    @MapsId("courseId")
    Course course;

    @ManyToOne
    @MapsId("lessonId")
    Lesson lesson;
}
