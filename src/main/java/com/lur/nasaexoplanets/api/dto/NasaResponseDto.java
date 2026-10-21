package com.lur.nasaexoplanets.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class NasaResponseDto {
    private String pl_name;
    private String hostname;
    private Double ra;
    private Double dec;
    private Double sy_dist;
    private Double pl_rade;
    private String discoverymethod;
    private String disc_year;
    private String disc_telescope;
    private String disc_instrument;
    private Integer sy_mnum;
    private Double pl_masse;
    private Double pl_orbsmax;
    private Double st_mass;
    private Double pl_orbeccen;
    private Double pl_orbper;
    private Double pl_orbtper;
    private Double pl_orblper;
    private Double st_rad;
    private Double pl_orbincl;
}
