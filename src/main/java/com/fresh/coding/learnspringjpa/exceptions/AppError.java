package com.fresh.coding.learnspringjpa.exceptions;

import java.time.LocalDate;

public record AppError<T>(
        T message,
        LocalDate date,
        int status
) {
}
