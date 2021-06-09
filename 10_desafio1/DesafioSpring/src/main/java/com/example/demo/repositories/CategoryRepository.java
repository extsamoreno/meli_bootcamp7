package com.example.demo.repositories;

import com.example.demo.model.Category;

public interface CategoryRepository {

    Category findCategoryById(int category_id);

}
