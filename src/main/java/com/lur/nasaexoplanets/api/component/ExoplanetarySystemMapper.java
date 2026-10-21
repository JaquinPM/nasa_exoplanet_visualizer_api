package com.lur.nasaexoplanets.api.component;

import com.lur.nasaexoplanets.api.dto.ExoSystemFullResponseDto;
import com.lur.nasaexoplanets.api.dto.ExoSystemResponseDto;
import com.lur.nasaexoplanets.api.model.ExoplanetarySystem;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ExoplanetarySystemMapper {

    private ExoplanetMapper exoplanetMapper;
    public ExoSystemResponseDto toDto(ExoplanetarySystem exoplanetarySystem){
        return new ExoSystemResponseDto(
                exoplanetarySystem.getId(),
                exoplanetarySystem.getName(),
                exoplanetarySystem.getNumberMoons(),
                exoplanetarySystem.getStar()
        );

    }

    public ExoSystemFullResponseDto toFullDto(ExoplanetarySystem exoplanetarySystem) {
        return new ExoSystemFullResponseDto(
                exoplanetarySystem.getId(),
                exoplanetarySystem.getName(),
                exoplanetarySystem.getNumberMoons(),
                exoplanetarySystem.getStar(),
                exoplanetarySystem.getExoplanets().stream().map(
                        exoplanet -> exoplanetMapper.toDto(exoplanet)
                ).toList()
        );
    }
}
