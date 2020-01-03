package com.aurel.lms.service.dto.response;

import com.aurel.lms.model.Attendance;
import lombok.Data;

@Data
public class AttendanceDTO {

    private int id;
    private UserDTO participant;
    private String memo;

    public AttendanceDTO(Attendance attendance) {

        this.id = attendance.getId();
        this.participant = new UserDTO(attendance.getParticipant());
        this.memo = attendance.getMemo();
    }
}
