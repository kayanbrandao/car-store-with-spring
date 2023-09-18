package com.carstorewithspring.data.dto;

import com.carstorewithspring.data.enums.GearboxType;
import com.carstorewithspring.data.entity.Model;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.Year;

public record CarDto(
        Long id,
        @NotEmpty String color,
        @NotEmpty String version,
        GearboxType gearbox,
        @NotNull Year year,
        @NotNull Model model
) {
}
