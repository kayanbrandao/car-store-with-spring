package com.carstorewithspring.data.mapper;

import com.carstorewithspring.data.response.BrandResponse;
import com.carstorewithspring.data.model.Brand;

import java.util.ArrayList;
import java.util.List;

public class BrandMapper {
    public static BrandResponse toResponse(Brand brand){
        return new BrandResponse(
                brand.getId(),
                brand.getName()
        );
    }

    public static List<BrandResponse> toResponse(List<Brand> brands){
        List<BrandResponse> brandResponses = new ArrayList<>();

        for (Brand brand : brands) {
            brandResponses.add(new BrandResponse(
                    brand.getId(),
                    brand.getName()
            ));
        }

        return brandResponses;
    }
}
