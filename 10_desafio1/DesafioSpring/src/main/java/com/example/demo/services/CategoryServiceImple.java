package com.example.demo.services;

import com.example.demo.repositories.CategoryRepositoryImple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImple implements CategoryService{
    @Autowired
    CategoryRepositoryImple categoryRepositoryImple;

    @Override
    public void addCategories() {
        categoryRepositoryImple.addCategory();
    }
}
