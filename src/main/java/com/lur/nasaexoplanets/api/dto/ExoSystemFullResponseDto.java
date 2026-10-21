package com.lur.nasaexoplanets.api.dto;

import com.lur.nasaexoplanets.api.model.Star;

import java.util.List;

public record ExoSystemFullResponseDto(
        int id,
        String name,
        int numberMoons,
        Star star,
        List<ExoplanetResponseDTO> exoplanets
) {
}
