package com.aurel.lms.service.dto.response;

import com.aurel.lms.model.Goal;
import com.aurel.lms.model.Notice;
import com.aurel.lms.model.Status;
import com.aurel.lms.model.course.Course;
import com.aurel.lms.model.course.WeekDay;
import com.aurel.lms.model.courseUser.CourseUser;
import com.aurel.lms.model.lesson.Lesson;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class CourseDTO {

    private String title;
    private String overview;
    private Status status;
    private WeekDay weekDay;
    private int period;
    private String imageUrl;
    private int termId;

    private Set<GoalDTO> goals;
    private Set<NoticeDTO> notices;
    private Set<LessonDTO> lessons;

    private Set<UserDTO> students;
    private Set<UserDTO> managers;
    private Set<UserDTO> assistants;
    private Set<UserDTO> supervisors;

    public CourseDTO(Course course) {

        this.title = course.getTitle();
        this.overview = course.getOverview();
        this.status = course.getStatus();
        this.weekDay = course.getWeekDay();
        this.period = course.getPeriod();
        this.imageUrl = course.getImage().getURL();
        this.termId = course.getTerm().getId();

        this.goals = new HashSet<>();
        for (Goal goal : course.getGoals()) {

            this.goals.add(new GoalDTO(goal));
        }

        this.notices = new HashSet<>();
        for (Notice notice : course.getNotices()) {

            this.notices.add(new NoticeDTO(notice));
        }

        this.lessons = new HashSet<>();
        for (Lesson lesson : course.getLessons()) {
            this.lessons.add(new LessonDTO(lesson));
        }

        this.students = new HashSet<>();
        this.managers = new HashSet<>();
        this.assistants = new HashSet<>();
        this.supervisors = new HashSet<>();
        for (CourseUser courseUser : course.getUsers()) {

            switch (courseUser.getType()){

                case STUDENT:
                    this.students.add(new UserDTO(courseUser.getUser()));
                case MANAGER:
                    this.managers.add(new UserDTO(courseUser.getUser()));
                case ASSISTANT:
                    this.assistants.add(new UserDTO(courseUser.getUser()));
                case SUPERVISOR:
                    this.supervisors.add(new UserDTO(courseUser.getUser()));
                default:
                    break;
            }
        }
    }
}