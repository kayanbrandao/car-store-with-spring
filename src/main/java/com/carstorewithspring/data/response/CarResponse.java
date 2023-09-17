package com.carstorewithspring.data.response;

import com.carstorewithspring.data.enums.GearboxType;
import com.carstorewithspring.data.model.Model;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.Year;

public record CarResponse(
        Long id,
        String color,
        String version,
        GearboxType gearbox,
        Year year,
        Model model
) {
}
