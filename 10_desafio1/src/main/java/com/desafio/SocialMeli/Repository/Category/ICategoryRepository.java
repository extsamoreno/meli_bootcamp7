package com.desafio.SocialMeli.Repository.Category;

import com.desafio.SocialMeli.Classes.Category;

public interface ICategoryRepository {

    void saveCategory (Category category);

    Category getCategoryById (int categoryId);
}
