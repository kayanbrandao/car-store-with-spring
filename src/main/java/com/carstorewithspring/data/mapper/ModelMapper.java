package com.carstorewithspring.data.mapper;

import com.carstorewithspring.data.dto.ModelDto;
import com.carstorewithspring.data.entity.Model;

import java.util.ArrayList;
import java.util.List;

public class ModelMapper {
    public static ModelDto toResponse(Model model){
        return new ModelDto(
                model.getId(),
                model.getName(),
                model.getBrand()
        );
    }

    public static List<ModelDto> toResponse(List<Model> models){
        List<ModelDto> modelDto = new ArrayList<>();

        for (Model model : models) {
            modelDto.add(new ModelDto(
                    model.getId(),
                    model.getName(),
                    model.getBrand()
            ));
        }

        return modelDto;
    }
}
