package com.carstorewithspring.data.mapper;

import com.carstorewithspring.data.api.ModelResponse;
import com.carstorewithspring.data.model.Model;

import java.util.ArrayList;
import java.util.List;

public class ModelMapper {
    public static ModelResponse toResponse(Model model){
        return new ModelResponse(
                model.getId(),
                model.getName(),
                model.getBrand()
        );
    }

    public static List<ModelResponse> toResponse(List<Model> models){
        List<ModelResponse> ModelResponses = new ArrayList<>();

        for (Model model : models) {
            ModelResponses.add(new ModelResponse(
                    model.getId(),
                    model.getName(),
                    model.getBrand()
            ));
        }

        return ModelResponses;
    }
}
