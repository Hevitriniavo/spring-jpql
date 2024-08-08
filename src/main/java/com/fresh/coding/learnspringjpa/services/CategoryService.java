package com.fresh.coding.learnspringjpa.services;

import com.fresh.coding.learnspringjpa.dtos.category.CategorySummarized;
import com.fresh.coding.learnspringjpa.dtos.category.CreateCategory;
import com.fresh.coding.learnspringjpa.dtos.category.UpdateCategory;

import java.util.List;


public interface CategoryService {
    CategorySummarized createCategory(CreateCategory toCreate);

    CategorySummarized updateCategory(UpdateCategory toUpdate);

    List<CategorySummarized> findAllCategories();

    CategorySummarized removeCategoryById(Long id);
}
