package com.fresh.coding.learnspringjpa.services.impl;

import com.fresh.coding.learnspringjpa.dtos.CategoryForm;
import com.fresh.coding.learnspringjpa.dtos.PageInfo;
import com.fresh.coding.learnspringjpa.dtos.Paginate;
import com.fresh.coding.learnspringjpa.entities.Category;
import com.fresh.coding.learnspringjpa.mappers.CategoryMapper;
import com.fresh.coding.learnspringjpa.repositories.CategoryRepository;
import com.fresh.coding.learnspringjpa.services.CategoryService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {
    @PersistenceContext
    private final EntityManager entityManager;

    private final CategoryRepository categoryRepository;

    private final CategoryMapper categoryMapper;

    @Transactional
    public List<Category> saveAllCategories(List<CategoryForm> categoryForms) {
        var savedCategories = new ArrayList<Category>();
        for (var categoryForm : categoryForms) {
            var category = categoryForm.id() != null
                    ? entityManager.find(Category.class, categoryForm.id())
                    : new Category();
            category = categoryMapper.toEntity(categoryForm);
            savedCategories.add(category);
        }
        return categoryRepository.saveAll(savedCategories);
    }

    @Override
    public Paginate<List<Category>> findAllCategories(int page, int size) {
        var categories = entityManager.createQuery("SELECT c FROM Category c", Category.class)
                .setFirstResult(page * size)
                .setMaxResults(size)
                .getResultList();
        var totalPages = (long) (entityManager.createQuery("SELECT COUNT(c) FROM Category c")
                .getSingleResult());

        var pageInfo = new PageInfo(
                page < totalPages / size,
                page > 0
        );
        return new Paginate<>(categories, pageInfo, totalPages);
    }

    public Paginate<List<Category>> jpaAllCategories(int page, int size) {
        var pages = PageRequest.of(page, size);
        var categories = categoryRepository.findAll(pages);
        var totalPages = categoryRepository.count();

        var pageInfo = new PageInfo(
                page < totalPages / size,
                page > 0
        );
        return new Paginate<>(
                categories.getContent(),
                pageInfo,
                totalPages
        );
    }
}
