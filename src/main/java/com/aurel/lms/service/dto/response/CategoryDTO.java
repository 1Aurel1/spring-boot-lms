package com.aurel.lms.service.dto.response;

import com.aurel.lms.model.Category;
import lombok.Data;

@Data
public class CategoryDTO {

    private int id;
    private String name;

    public CategoryDTO(Category category) {
        
        this.id = category.getId();
        this.name = category.getName();
    }
}
