package com.aurel.lms.model.file;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class ImageFile extends File {

    public String getThumbNail(){
        return super.getFileURL() + FileConstants.THUMBNAIL + super.getFileName();
    }

    public String getMedium(){
        return super.getFileURL() + FileConstants.THUMBNAIL + super.getFileName();
    }
}
