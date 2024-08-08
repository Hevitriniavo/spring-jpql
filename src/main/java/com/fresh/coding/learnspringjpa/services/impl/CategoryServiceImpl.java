package com.fresh.coding.learnspringjpa.services.impl;

import com.fresh.coding.learnspringjpa.dtos.category.CategorySummarized;
import com.fresh.coding.learnspringjpa.dtos.category.CreateCategory;
import com.fresh.coding.learnspringjpa.dtos.category.UpdateCategory;
import com.fresh.coding.learnspringjpa.exceptions.HttpNotFoundException;
import com.fresh.coding.learnspringjpa.mappers.CategoryMapper;
import com.fresh.coding.learnspringjpa.repositories.CategoryRepository;
import com.fresh.coding.learnspringjpa.repositories.RepositoryFactory;
import com.fresh.coding.learnspringjpa.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryMapper categoryMapper;
    private final RepositoryFactory repositoryFactory;

    private CategoryRepository getCategoryRepository() {
        return repositoryFactory.getCategoryRepository();
    }

    @Transactional
    @Override
    public CategorySummarized createCategory(CreateCategory toCreate) {
        var category = categoryMapper.toEntity(toCreate);
        var savedCategory = this.getCategoryRepository().save(category);
        return categoryMapper.toSummary(savedCategory);
    }

    @Transactional
    @Override
    public CategorySummarized updateCategory(UpdateCategory toUpdate) {
        if (toUpdate == null || toUpdate.getId() == null) {
            throw new HttpNotFoundException("Category ID is missing");
        }

        var categoryRepository = this.getCategoryRepository();
        var existingCategory = categoryRepository.findById(toUpdate.getId())
                .orElseThrow(() -> new HttpNotFoundException("Category with ID " + toUpdate.getId() + " not found"));

        existingCategory.setName(toUpdate.getName());
        existingCategory.setDescription(toUpdate.getDescription());

        var savedCategory = categoryRepository.save(existingCategory);
        return categoryMapper.toSummary(savedCategory);
    }

    @Transactional(readOnly = true)
    @Override
    public List<CategorySummarized> findAllCategories() {
        return getCategoryRepository().findAllCategories();
    }

    @Override
    public CategorySummarized removeCategoryById(Long id) {
        var categoryRepository = getCategoryRepository();
        var categoryOptional = categoryRepository.findById(id);
        if (categoryOptional.isEmpty()) {
            throw new HttpNotFoundException("Category with ID " + id + " not found");
        }
        var category = categoryOptional.get();
        categoryRepository.deleteById(id);
        return this.categoryMapper.toSummary(category);
    }
}
