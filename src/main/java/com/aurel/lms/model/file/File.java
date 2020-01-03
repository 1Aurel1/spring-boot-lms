package com.aurel.lms.model.file;

import com.aurel.lms.model.AbstractAuditingEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@MappedSuperclass
@EqualsAndHashCode(callSuper = true)
public abstract class File extends AbstractAuditingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String URL;

    private String uploadContentType;

    private String uploadFileSize;
}
