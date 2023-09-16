package com.carstorewithspring.data.api;

import jakarta.validation.constraints.NotBlank;

public record BrandRequest(
        @NotBlank String name
) {
}
