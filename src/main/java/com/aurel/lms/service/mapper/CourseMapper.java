package com.aurel.lms.service.mapper;

import com.aurel.lms.exeption.ResourceNotFoundException;
import com.aurel.lms.model.Goal;
import com.aurel.lms.model.course.Course;
import com.aurel.lms.model.Status;
import com.aurel.lms.model.course.WeekDay;
import com.aurel.lms.model.courseUser.CourseUser;
import com.aurel.lms.repository.TermRepository;
import com.aurel.lms.service.dto.request.course.CourseUserDTO;
import com.aurel.lms.service.dto.request.course.CreateCourseRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class CourseMapper {

    private TermRepository termRepository;
    private UserMapper userMapper;

    @Autowired
    public CourseMapper(TermRepository termRepository, UserMapper mapper) {

        this.termRepository = termRepository;
        this.userMapper = mapper;
    }

    public Course createCourseRequestToCourse(CreateCourseRequest request){

        if (request == null)

            return null;
        else {

            Course course = new Course();
            course.setTitle(request.getTitle());
            course.setOverview(request.getOverview());
            course.setStatus(Status.valueOf(request.getStatus()));
            course.setWeekDay(WeekDay.valueOf(request.getWeekDay()));
            course.setPeriod(request.getPeriod());
            course.setEnabled(request.isEnabled());

            if (request.getTermID() > 0)
                course.setTerm(termRepository.getById(request.getTermID()).orElseThrow(() -> new ResourceNotFoundException("Term", "Id", request.getTermID())));

            Set<Goal> goals = new HashSet<>();
            for (String goalTitle : request.getGoals()) {
                Goal goal = new Goal();
                goal.setTitle(goalTitle);
                goals.add(goal);
            }
            course.setGoals(goals);

            Set<CourseUser> users = new HashSet<>();
            for (CourseUserDTO userDTO : request.getUsers())
                users.add(userMapper.courseUserDtoTOUser(userDTO));
            course.setUsers(users);

            return course;
        }
    }
}
