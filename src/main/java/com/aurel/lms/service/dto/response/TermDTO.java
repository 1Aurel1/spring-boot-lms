package com.aurel.lms.service.dto.response;

import com.aurel.lms.model.Term;
import com.aurel.lms.util.DateUtil;
import lombok.Data;

@Data
public class TermDTO {

    private int id;
    private String title;
    private String startAt;
    private String endAt;
    private String guid;

    public TermDTO(Term term) {

        this.id = term.getId();
        this.title = term.getTitle();
        this.startAt = DateUtil.dateToFormat1(term.getStartAt());
        this.endAt = DateUtil.dateToFormat1(term.getEndAt());
        this.guid = term.getGuid();
    }
}
