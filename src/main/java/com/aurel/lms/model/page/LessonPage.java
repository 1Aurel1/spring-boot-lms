package com.aurel.lms.model.page;

import com.aurel.lms.model.file.File;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.Set;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class LessonPage extends Page{

    private int displayOrder;

    @OneToOne
    private File pageFile;
}
