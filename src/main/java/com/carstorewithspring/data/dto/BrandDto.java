package com.carstorewithspring.data.dto;

import jakarta.validation.constraints.NotEmpty;

public record BrandDto(
        Long id,
        @NotEmpty String name
) {
}
