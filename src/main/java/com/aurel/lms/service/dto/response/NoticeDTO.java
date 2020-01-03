package com.aurel.lms.service.dto.response;

import com.aurel.lms.model.Notice;
import lombok.Data;

@Data
public class NoticeDTO {

    private int id;
    private String message;
    private UserDTO user;

    public NoticeDTO(Notice notice) {

        this.id = notice.getId();
        this.message = notice.getMessage();
        this.user = new UserDTO(notice.getUser());
    }
}
