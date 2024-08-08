package com.fresh.coding.learnspringjpa.dtos.category;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public final class UpdateCategory extends CategoryBase implements Serializable {
    @NotNull(message = "Id cannot be null")
    private Long id;

    public UpdateCategory(
            Long id,
            String name,
            String description
    ) {
        super(name, description);
        this.id = id;
    }
}
