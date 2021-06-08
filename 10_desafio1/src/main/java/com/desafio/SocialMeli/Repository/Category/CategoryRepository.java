package com.desafio.SocialMeli.Repository.Category;

import com.desafio.SocialMeli.Classes.Category;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CategoryRepository implements ICategoryRepository {

    List<Category> categoryList = new ArrayList<>();

    @Override
    public void saveCategory(Category category) {
        categoryList.add(category);
    }

    @Override
    public Category getCategoryById(int categoryId) {
        return categoryList.stream().filter(category -> category.getCategoryId() == categoryId).findFirst().orElse(null);
    }
}
