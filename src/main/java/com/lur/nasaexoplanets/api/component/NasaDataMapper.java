package com.lur.nasaexoplanets.api.component;

import com.lur.nasaexoplanets.api.dto.NasaResponseDto;
import com.lur.nasaexoplanets.api.model.Exoplanet;
import com.lur.nasaexoplanets.api.model.ExoplanetarySystem;
import com.lur.nasaexoplanets.api.model.Star;
import org.springframework.stereotype.Component;

@Component
public class NasaDataMapper {




    public ExoplanetarySystem convertToExoplanetarySystem(NasaResponseDto nasaExoplanetDto){
        Star star = convertToStar(nasaExoplanetDto);
        ExoplanetarySystem exoplanetarySystem = new ExoplanetarySystem();
        exoplanetarySystem.setName(nasaExoplanetDto.getHostname());
        exoplanetarySystem.setNumberMoons(nasaExoplanetDto.getSy_mnum());
        exoplanetarySystem.setStar(star);
        return exoplanetarySystem;
    }

    private Star convertToStar(NasaResponseDto nasaExoplanetDto){
        Star star = new Star();
        Double[] coordinates = get3DCoordinates(nasaExoplanetDto.getRa(), nasaExoplanetDto.getDec(), nasaExoplanetDto.getSy_dist());
        star.setX(coordinates[0]);
        star.setY(coordinates[1]);
        star.setZ(coordinates[2]);
        star.setMass(nasaExoplanetDto.getSt_mass());
        star.setRadius(nasaExoplanetDto.getSt_rad());
        return star;
    }

    public Exoplanet convertToExoplanet(NasaResponseDto nasaExoplanetDto){
        Exoplanet exoplanet = new Exoplanet();
        exoplanet.setMass(nasaExoplanetDto.getPl_masse());
        exoplanet.setDiscInstrument(nasaExoplanetDto.getDisc_instrument());
        exoplanet.setDiscoveryMethod(nasaExoplanetDto.getDiscoverymethod());
        exoplanet.setDiscoveryYear(nasaExoplanetDto.getDisc_year());
        exoplanet.setDiscTelescope(nasaExoplanetDto.getDisc_telescope());
        exoplanet.setName(nasaExoplanetDto.getPl_name());
        exoplanet.setRadius(nasaExoplanetDto.getPl_rade());
        exoplanet.setSemiMajorAxis(nasaExoplanetDto.getPl_orbsmax());
        exoplanet.setOrbitEccentricity(nasaExoplanetDto.getPl_orbeccen());
        exoplanet.setOrbitInclination(nasaExoplanetDto.getPl_orbincl());
        exoplanet.setOrbitPeriod(nasaExoplanetDto.getPl_orbper());
        exoplanet.setPeriastronEpoch(nasaExoplanetDto.getPl_orbtper());
        exoplanet.setPeriastronDeg(nasaExoplanetDto.getPl_orblper());

        // Coordinates will be computed later
        return exoplanet;
    }

    private Double[] get3DCoordinates(Double ra, Double dec, Double dist){
        Double x = null, y = null, z= null;

        if (dist != null && ra !=null && dec != null){
            double raRadians = Math.toRadians(ra);
            double decRadians = Math.toRadians(dec);
            x = dist* Math.cos(decRadians)*Math.cos(raRadians);
            y = dist* Math.cos(decRadians)*Math.sin(raRadians);
            z = dist* Math.sin(decRadians);

        }

        return new Double[]{x,y,z};
    }
}
