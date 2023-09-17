package com.carstorewithspring.data.request;

import jakarta.validation.constraints.NotBlank;

public record BrandRequest(
        @NotBlank String name
) {
}
