package com.fresh.coding.learnspringjpa.controllers;

import com.fresh.coding.learnspringjpa.dtos.CategoryForm;
import com.fresh.coding.learnspringjpa.dtos.Paginate;
import com.fresh.coding.learnspringjpa.entities.Category;
import com.fresh.coding.learnspringjpa.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping
    public List<Category> saveAllCategories(@RequestBody List<CategoryForm> categories) {
        return categoryService.saveAllCategories(categories);
    }

    @GetMapping
    public Paginate<List<Category>> findAllCategories(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return categoryService.jpaAllCategories(page, size);
    }
}
