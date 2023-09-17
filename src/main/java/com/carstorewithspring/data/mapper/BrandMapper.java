package com.carstorewithspring.data.mapper;

import com.carstorewithspring.data.dto.BrandDto;
import com.carstorewithspring.data.model.Brand;

import java.util.ArrayList;
import java.util.List;

public class BrandMapper {
    public static BrandDto toResponse(Brand brand){
        return new BrandDto(
                brand.getId(),
                brand.getName()
        );
    }

    public static List<BrandDto> toResponse(List<Brand> brands){
        List<BrandDto> BrandDto = new ArrayList<>();

        for (Brand brand : brands) {
            BrandDto.add(new BrandDto(
                    brand.getId(),
                    brand.getName()
            ));
        }

        return BrandDto;
    }
}
