package com.fresh.coding.learnspringjpa.repositories;

import com.fresh.coding.learnspringjpa.dtos.category.CategorySummarized;
import com.fresh.coding.learnspringjpa.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Query("""
            SELECT
                NEW com.fresh.coding.learnspringjpa.dtos.category.CategorySummarized(
                c.id, c.name, c.description, c.createdAt, c.updatedAt
                )
            FROM
               Category c
            """)
    List<CategorySummarized> findAllCategories();
}
