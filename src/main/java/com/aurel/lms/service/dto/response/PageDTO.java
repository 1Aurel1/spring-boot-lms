package com.aurel.lms.service.dto.response;

import com.aurel.lms.model.page.LessonPage;
import com.aurel.lms.model.page.PageFileType;
import lombok.Data;

@Data
public class PageDTO {

    private int id;
    private String URL;
    private PageFileType type;

    public PageDTO(LessonPage page) {
        this.id = page.getId();
        this.URL = page.getURL();
        this.type = page.getPageFileType();
    }
}
