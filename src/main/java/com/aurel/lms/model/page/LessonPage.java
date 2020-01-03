package com.aurel.lms.model.page;

import com.aurel.lms.model.Content;
import com.aurel.lms.model.file.File;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class LessonPage extends File {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private PageFileType pageFileType;

    @ManyToOne
    @JoinColumn(name = "content_id")
    private Content content;
}
