package com.aurel.lms.model.file;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class ImageFile extends File {

    public String getThumbNail(){
        return super.getURL() + FileConstants.THUMBNAIL + super.getName();
    }

    public String getMedium(){
        return super.getURL() + FileConstants.MEDIUM + super.getName();
    }
}
