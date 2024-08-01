package com.fresh.coding.learnspringjpa.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Paginate<T> {
    private T data;
    private PageInfo pageInfo;
    private Long totalPages;
}
