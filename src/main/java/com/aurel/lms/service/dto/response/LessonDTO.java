package com.aurel.lms.service.dto.response;

import com.aurel.lms.model.Attendance;
import com.aurel.lms.model.Content;
import com.aurel.lms.model.GoalObjectives;
import com.aurel.lms.model.Lesson;
import com.aurel.lms.util.DateConverter;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class LessonDTO {

    private int id;
    private int displayOrder;
    private String attendanceStartAt;
    private String attendanceEndAt;

    private Set<GoalObjectivesDTO> goalObjectivesSet;
    private Set<AttendanceDTO> attendances;
    private Set<ContentDTO> contents;

    public LessonDTO(Lesson lesson) {

        this.id = lesson.getId();
        this.displayOrder = lesson.getDisplayOrder();
        this.attendanceStartAt = DateConverter.dateToFormat1(lesson.getAttendanceStartAt());
        this.attendanceEndAt = DateConverter.dateToFormat1(lesson.getAttendanceEndAt());

        this.goalObjectivesSet = new HashSet<>();
        for (GoalObjectives goalObjectives : lesson.getGoalObjectives()) {

            this.goalObjectivesSet.add(new GoalObjectivesDTO(goalObjectives));
        }

        this.attendances = new HashSet<>();
        for (Attendance attendance : lesson.getAttendances()) {

            this.attendances.add(new AttendanceDTO(attendance));
        }

        this.contents = new HashSet<>();
        for (Content content : lesson.getContents()) {

            this.contents.add(new ContentDTO(content));
        }
    }
}
