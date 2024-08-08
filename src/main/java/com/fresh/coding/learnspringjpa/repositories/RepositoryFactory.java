package com.fresh.coding.learnspringjpa.repositories;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Map;

@RequiredArgsConstructor
@Repository
public class RepositoryFactory {

    private final Map<String, JpaRepository<?, ?>> repositories;

    @SuppressWarnings("unchecked")
    private <T extends JpaRepository<?, ?>> T getRepositoryFor(String name) {
        JpaRepository<?, ?> repository = repositories.get(name);
        if (repository == null) {
            throw new IllegalArgumentException(String.format("Repository %s not defined", name));
        }
        return (T) repository;
    }

    public CategoryRepository getCategoryRepository() {
        return getRepositoryFor("categoryRepository");
    }

    public ProductRepository getProductRepository() {
        return getRepositoryFor("productRepository");
    }
}
