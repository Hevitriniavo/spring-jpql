package com.fresh.coding.learnspringjpa.services;


import com.fresh.coding.learnspringjpa.dtos.CategoryForm;
import com.fresh.coding.learnspringjpa.dtos.Paginate;
import com.fresh.coding.learnspringjpa.entities.Category;

import java.util.List;

public interface CategoryService {
    List<Category> saveAllCategories(List<CategoryForm> categories);

    Paginate<List<Category>> findAllCategories(int page, int size);

    Paginate<List<Category>> jpaAllCategories(int page, int size);
}
