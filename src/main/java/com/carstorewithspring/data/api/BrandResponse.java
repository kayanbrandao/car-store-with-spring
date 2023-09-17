package com.carstorewithspring.data.api;

import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public record BrandResponse(
        Long id,
        String name
) {
}
