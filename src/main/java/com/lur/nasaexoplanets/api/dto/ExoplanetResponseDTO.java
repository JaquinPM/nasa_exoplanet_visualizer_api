package com.lur.nasaexoplanets.api.dto;

public record ExoplanetResponseDTO(
        Integer id,
        String name,
        Double radius,
        Double mass,
        Double orbitEccentricity,
        Double orbitPeriod,
        Double orbitInclination,
        String discoveryMethod,
        String discoveryYear,
        String discTelescope,
        String discInstrument,
        Double semiMajorAxis,
        Double periastronEpoch,
        Double periastronAngle,
        Integer idExoplanetarySystem
) {}
