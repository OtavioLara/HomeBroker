package com.inter.investing;

import java.time.LocalDateTime;

public record ShareDTO(
        String symbol,
        Double price,
        String currency,
        LocalDateTime date
) {
}
