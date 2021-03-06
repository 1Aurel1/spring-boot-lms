package com.aurel.lms.model;

import com.aurel.lms.model.file.AssetFile;
import com.aurel.lms.model.file.AttachmentFile;
import com.aurel.lms.model.lesson.Lesson;
import com.aurel.lms.model.page.LessonPage;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class Content extends AbstractAuditingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String title;

    @Column(unique = true, nullable = false)
    private String folderName;

    @Column(name = "c_condition")
    private String condition;

    @Column
    private String overview;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "content")
    private Set<AssetFile> assetFiles;

    @OneToMany(mappedBy = "content")
    private Set<AttachmentFile> attachmentFiles;

    @OneToMany(mappedBy = "content")
    private Set<LessonPage> lessonPages;

    @OneToMany(mappedBy = "content")
    private Set<Objective> objectives;

    @ManyToMany
    @JoinTable( name = "content_lesson",
                joinColumns = @JoinColumn(name = "lesson_id", referencedColumnName = "id"),
                inverseJoinColumns = @JoinColumn(name = "content_id", referencedColumnName = "id"))
    private Set<Lesson> lessons;

    public Content() {

        this.assetFiles = new HashSet<>();
        this.attachmentFiles = new HashSet<>();
        this.lessonPages = new HashSet<>();
        this.objectives = new HashSet<>();
        this.lessons = new HashSet<>();
    }
}