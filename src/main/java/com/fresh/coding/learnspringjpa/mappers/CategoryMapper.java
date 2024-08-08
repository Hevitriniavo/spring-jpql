package com.fresh.coding.learnspringjpa.mappers;

import com.fresh.coding.learnspringjpa.dtos.category.CategorySummarized;
import com.fresh.coding.learnspringjpa.dtos.category.CreateCategory;
import com.fresh.coding.learnspringjpa.entities.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {
    public CategorySummarized toSummary(Category savedCategory) {
        return new CategorySummarized(
                savedCategory.getId(),
                savedCategory.getName(),
                savedCategory.getDescription(),
                savedCategory.getCreatedAt(),
                savedCategory.getUpdatedAt()
        );
    }

    public Category toEntity(CreateCategory toCreate) {
        return Category.builder()
                .description(toCreate.getDescription())
                .name(toCreate.getName())
                .build();
    }
}
