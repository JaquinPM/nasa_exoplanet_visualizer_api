package com.lur.nasaexoplanets.api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@AllArgsConstructor
@Getter
@Setter
@Entity
@NoArgsConstructor
public class Exoplanet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Double radius;
    private Double mass;
    private Double orbitEccentricity;
    private Double orbitPeriod;
    private Double orbitInclination;
    private String discoveryMethod;
    private String discoveryYear;
    private String discTelescope;
    private String discInstrument;
    private Double semiMajorAxis;
    private Double periastronDeg;
    private Double periastronEpoch;

    @ManyToOne
    private ExoplanetarySystem exoplanetarySystem;
}