package com.carstorewithspring.data.dto;

import com.carstorewithspring.data.enums.RoleType;
import jakarta.validation.constraints.NotBlank;

public record UserDto(
        Long id,
        @NotBlank String username,
        @NotBlank String password,
        RoleType role
) {
}
