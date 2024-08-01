package com.fresh.coding.learnspringjpa.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record CategoryForm(Long id, @NotEmpty @NotNull String name, String description) {
}
