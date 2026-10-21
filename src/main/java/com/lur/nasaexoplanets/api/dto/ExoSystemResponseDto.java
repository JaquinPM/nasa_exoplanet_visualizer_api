package com.lur.nasaexoplanets.api.dto;

import com.lur.nasaexoplanets.api.model.Star;

public record ExoSystemResponseDto(
        int id,
        String name,
        int numberMoons,
        Star star
) {
}
