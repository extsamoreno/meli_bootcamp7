package com.example.demo.services.mappers;

import com.example.demo.dtos.CategoryDTO;
import com.example.demo.model.Category;

public class CategoryMapper {

    public static CategoryDTO toDTO(Category category){
                return new CategoryDTO(category.getCategoryName());
    }
}
