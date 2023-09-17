package com.carstorewithspring.data.api;

import com.carstorewithspring.data.model.Brand;

public record ModelResponse(
        Long id,
        String name,
        Brand brand
) {
}
