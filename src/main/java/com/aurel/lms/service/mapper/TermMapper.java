package com.aurel.lms.service.mapper;

import com.aurel.lms.model.course.Course;
import com.aurel.lms.model.Term;
import com.aurel.lms.repository.CourseRepository;
import com.aurel.lms.service.dto.request.term.CreateTermRequest;
import com.aurel.lms.util.DateConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class TermMapper {

    private CourseRepository courseRepository;

    @Autowired
    public TermMapper(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public Term createTermRequestToTerm(CreateTermRequest request){

        if (request == null)

            return null;
        else {
            Term term = new Term();
            term.setTitle(request.getTitle());
            term.setStartAt(DateConverter.format1ToDate(request.getStartAt()));
            term.setEndAt(DateConverter.format1ToDate(request.getEndAt()));
            term.setGuid(request.getGuid());
            Set<Course> courses = new HashSet<>();
            if (request.getCourses() != null)
                if (!request.getCourses().isEmpty())
                    courses = (Set<Course>) courseRepository.findAllById(request.getCourses());
            term.setCourses(courses);

            return term;
        }
    }
}
