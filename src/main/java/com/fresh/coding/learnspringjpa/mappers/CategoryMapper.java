package com.fresh.coding.learnspringjpa.mappers;

import com.fresh.coding.learnspringjpa.dtos.CategoryForm;
import com.fresh.coding.learnspringjpa.entities.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {

    public Category toEntity(CategoryForm categoryForm){
        return new Category(
                null,
                categoryForm.name(),
                categoryForm.description()
        );
    }

    public Category toEntity(CategoryForm categoryForm, Long id){
        return new Category(
                id,
                categoryForm.name(),
                categoryForm.description()
        );
    }
}
