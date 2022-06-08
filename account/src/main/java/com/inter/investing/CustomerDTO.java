package com.inter.investing;

public record CustomerDTO(
        Integer id,
        String name,
        String cpf,
        String email
) {
}
