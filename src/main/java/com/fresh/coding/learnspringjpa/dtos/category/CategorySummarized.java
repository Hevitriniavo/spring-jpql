package com.fresh.coding.learnspringjpa.dtos.category;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
public final class CategorySummarized extends CategoryBase implements Serializable {
    private Long id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public CategorySummarized(
            Long id,
            String name,
            String description,
            LocalDateTime createdAt,
            LocalDateTime updatedAt
    ) {
        super(name, description);
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
