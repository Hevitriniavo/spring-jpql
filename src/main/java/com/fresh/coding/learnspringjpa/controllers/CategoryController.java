package com.fresh.coding.learnspringjpa.controllers;

import com.fresh.coding.learnspringjpa.dtos.category.CategorySummarized;
import com.fresh.coding.learnspringjpa.dtos.category.CreateCategory;
import com.fresh.coding.learnspringjpa.dtos.category.UpdateCategory;
import com.fresh.coding.learnspringjpa.services.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping
    public CategorySummarized createCategory(@Valid @RequestBody CreateCategory toCreate) {
        return categoryService.createCategory(toCreate);
    }

    @PutMapping
    public CategorySummarized updateCategory(@Valid @RequestBody UpdateCategory toUpdate) {
        return categoryService.updateCategory(toUpdate);
    }

    @GetMapping
    public List<CategorySummarized> getAllCategories() {
        return categoryService.findAllCategories();
    }

    @DeleteMapping("/{id}")
    public CategorySummarized removeCategoryById(@PathVariable Long id) {
        return categoryService.removeCategoryById(id);
    }
}
