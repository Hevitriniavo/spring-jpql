package com.fresh.coding.learnspringjpa.dtos.category;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public final class CreateCategory extends CategoryBase implements Serializable {
    public CreateCategory(
            String name,
            String description
    ) {
        super(name, description);
    }
}
