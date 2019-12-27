package com.aurel.lms.model.file;

import com.aurel.lms.model.Content;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class AttachmentFile extends File {

    @ManyToOne
    @JoinColumn(name = "content_id")
    private Content content;
}
