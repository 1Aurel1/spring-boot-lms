package com.aurel.lms.service.dto.response;

import com.aurel.lms.model.file.AssetFile;
import com.aurel.lms.model.file.AttachmentFile;
import com.aurel.lms.model.file.File;
import lombok.Data;

@Data
public class FileDTO {

    private String fileName;
    private String URL;

    public FileDTO(File file) {
        this.fileName = file.getName();
        this.URL = file.getURL();
    }
}
