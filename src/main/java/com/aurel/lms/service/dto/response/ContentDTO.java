package com.aurel.lms.service.dto.response;

import com.aurel.lms.model.Content;
import com.aurel.lms.model.lesson.Lesson;
import com.aurel.lms.model.Objective;
import com.aurel.lms.model.Status;
import com.aurel.lms.model.file.File;
import com.aurel.lms.model.page.LessonPage;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class ContentDTO {

    private int id;
    private String title;
    private String condition;
    private String overview;
    private Status status;
    private CategoryDTO category;
    private UserDTO owner;

    private Set<FileDTO> assetFiles;
    private Set<FileDTO> attachmentFiles;
    private Set<PageDTO> pages;
    private Set<ObjectiveDTO> objectives;

    private Set<Integer> lessons;

    public ContentDTO(Content content) {

        this.id = content.getId();
        this.title = content.getTitle();
        this.condition = content.getCondition();
        this.overview = content.getOverview();
        this.status = content.getStatus();

        this.category = new CategoryDTO(content.getCategory());
        this.owner = new UserDTO(content.getOwner());

        this.assetFiles = new HashSet<>();
        for (File file : content.getAssetFiles()) {

            this.assetFiles.add(new FileDTO(file));
        }


        this.attachmentFiles = new HashSet<>();
        for (File file : content.getAssetFiles()) {

            this.attachmentFiles.add(new FileDTO(file));
        }

        this.pages = new HashSet<>();
        for (LessonPage page : content.getLessonPages()) {

            this.pages.add(new PageDTO(page));
        }

        this.objectives = new HashSet<>();
        for (Objective objective: content.getObjectives()) {

            this.objectives.add(new ObjectiveDTO(objective));
        }

        this.lessons = new HashSet<>();
        for (Lesson lesson: content.getLessons()) {

            this.lessons.add(lesson.getId());
        }
    }
}
