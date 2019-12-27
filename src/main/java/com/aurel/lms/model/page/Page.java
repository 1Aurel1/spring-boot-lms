package com.aurel.lms.model.page;

import com.aurel.lms.model.AbstractAuditingEntity;
import com.aurel.lms.model.Content;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@MappedSuperclass
@EqualsAndHashCode(callSuper = true)
public class Page extends AbstractAuditingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "content_id")
    private Content content;
}
