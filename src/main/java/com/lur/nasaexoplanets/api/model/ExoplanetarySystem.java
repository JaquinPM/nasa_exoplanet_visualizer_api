package com.lur.nasaexoplanets.api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExoplanetarySystem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @OneToMany(mappedBy = "exoplanetarySystem", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Exoplanet> exoplanets = new ArrayList<>();

    private int numberMoons;

    @OneToOne(cascade = CascadeType.ALL)
    private Star star;
}
