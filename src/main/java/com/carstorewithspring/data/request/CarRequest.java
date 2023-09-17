package com.carstorewithspring.data.request;

import com.carstorewithspring.data.enums.GearboxType;
import com.carstorewithspring.data.model.Model;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.Year;

public record CarRequest(
        @NotBlank String color,
        @NotBlank String version,
        GearboxType gearbox,
        @NotNull Year year,
        @NotNull Model model
) {
}
