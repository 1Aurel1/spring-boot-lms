package com.aurel.lms.service.mapper;

import com.aurel.lms.model.course.Course;
import com.aurel.lms.model.Status;
import com.aurel.lms.service.dto.request.course.CreateCourseRequest;
import org.springframework.stereotype.Service;

@Service
public class CourseMapper {

    public Course createCourseRequestToCourse(CreateCourseRequest request){
        Course course = new Course();
        course.setTitle(request.getTitle());
        course.setOverview(request.getOverview());
        course.setStatus(Status.valueOf(request.getStatus()));
        /*course.setWeekDay(request.getWeekDay()); */
        course.setPeriod(request.getPeriod());
        course.setEnabled(request.isEnabled());
        return course;
    }
}
