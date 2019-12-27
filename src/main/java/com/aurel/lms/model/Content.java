package com.aurel.lms.model;

import com.aurel.lms.model.file.AssetFile;
import com.aurel.lms.model.file.AttachmentFile;
import com.aurel.lms.model.page.LessonPage;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class Content extends AbstractAuditingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

    private String folderName;

    private String condition;

    private String overview;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "content")
    private Set<Objective> objectives;

    @OneToMany(mappedBy = "content")
    private Set<LessonPage> lessonPages;

    @OneToMany(mappedBy = "content")
    private Set<AttachmentFile> attachmentFiles;

    @OneToMany(mappedBy = "content")
    private Set<AssetFile> assetFiles;

    @ManyToMany
    @JoinTable
    private Set<Lesson> lessons;
}
