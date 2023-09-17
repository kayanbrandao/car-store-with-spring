package com.carstorewithspring.data.request;

import com.carstorewithspring.data.model.Brand;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record ModelRequest(
    @NotBlank String name,
    @NotNull Brand brand
) {
}
