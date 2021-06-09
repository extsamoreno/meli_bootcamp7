package com.example.demo.repositories;

import com.example.demo.model.Category;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CategoryRepositoryImple implements CategoryRepository {
    List<Category> categoryList = new ArrayList<>();
    Category category = new Category(100,"Sillas");


    public void addCategory(){
        categoryList.add(category);
    }

    @Override
    public Category findCategoryById(int category_id) {
        Category categoryR = null;
        for(Category category:categoryList){
            if( category.getCategory_id() == category_id){
                categoryR = category;
            }
        }

        if(categoryR == null){

        }
        return categoryR;
    }
}
