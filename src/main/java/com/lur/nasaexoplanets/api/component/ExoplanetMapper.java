package com.lur.nasaexoplanets.api.component;

import com.lur.nasaexoplanets.api.dto.ExoplanetResponseDTO;
import com.lur.nasaexoplanets.api.model.Exoplanet;
import org.springframework.stereotype.Component;

@Component
public class ExoplanetMapper {
    public ExoplanetResponseDTO toDto(Exoplanet exoplanet){
        return  new ExoplanetResponseDTO(
                exoplanet.getId(),
                exoplanet.getName(),
                exoplanet.getRadius(),
                exoplanet.getMass(),
                exoplanet.getOrbitEccentricity(),
                exoplanet.getOrbitPeriod(),
                exoplanet.getOrbitInclination(),
                exoplanet.getDiscoveryMethod(),
                exoplanet.getDiscoveryYear(),
                exoplanet.getDiscTelescope(),
                exoplanet.getDiscInstrument(),
                exoplanet.getSemiMajorAxis(),
                exoplanet.getPeriastronEpoch(),
                exoplanet.getPeriastronDeg(),
                exoplanet.getExoplanetarySystem().getId()
        );
    }
}
