package com.carstorewithspring.data.dto;

import com.carstorewithspring.data.entity.Brand;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record ModelDto(
    Long id,
    @NotEmpty  String name,
    @NotNull Brand brand
) {
}
