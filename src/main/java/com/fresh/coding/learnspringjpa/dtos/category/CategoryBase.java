package com.fresh.coding.learnspringjpa.dtos.category;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
sealed class CategoryBase permits CreateCategory, UpdateCategory, CategorySummarized {
    @NotBlank(message = "Name cannot be empty")
    @Size(max = 150, message = "Name must be less than 100 characters")
    private String name;

    @Size(max = 255, message = "Description must be less than 255 characters")
    private String description;
}
