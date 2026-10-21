package com.lur.nasaexoplanets.api.service;

import com.lur.nasaexoplanets.api.component.NasaDataMapper;
import com.lur.nasaexoplanets.api.dto.NasaResponseDto;
import com.lur.nasaexoplanets.api.model.Exoplanet;
import com.lur.nasaexoplanets.api.model.ExoplanetarySystem;
import com.lur.nasaexoplanets.api.repository.SystemRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.jspecify.annotations.NonNull;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
@Setter
@Getter
@AllArgsConstructor
public class NasaIntegrationService implements ApplicationRunner {
    private SystemRepository systemRepository;
    private NasaDataMapper nasaDataMapper;
    private final String url="https://exoplanetarchive.ipac.caltech.edu/TAP/sync?query=select+pl_name,st_rad,hostname,ra,dec,sy_dist,pl_rade,discoverymethod,disc_year,disc_telescope,disc_instrument,sy_mnum,pl_masse,pl_orblper,pl_orbtper,st_mass,pl_orbsmax,pl_orbeccen,pl_orbper,pl_orbincl+from+pscomppars&format=json";
    private final RestTemplate restTemplate = new RestTemplate();


    @Override
    public void run(@NonNull ApplicationArguments args) {
        syncData(this.url);
    }

    @Scheduled(cron = "@monthly")
    public void syncDataScheduled(){
        syncData(this.url);
    }

    private void syncData(String url){
        java.lang.System.out.println("Sincronizando data");
        NasaResponseDto[] nasaExoplanetDtos = fetchData(url);
        Collection<ExoplanetarySystem> exoplanetarySystems = parseNasaData(nasaExoplanetDtos);
        saveData(exoplanetarySystems);
    }

    private NasaResponseDto[] fetchData(String url){
        java.lang.System.out.println("Fetching data");
        NasaResponseDto[] nasaData = new NasaResponseDto[0];
        try {
            nasaData = restTemplate.getForObject(url, NasaResponseDto[].class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nasaData;
    }

    private void saveData(Collection<ExoplanetarySystem> exoplanetarySystems){
        java.lang.System.out.println("Savin data");
        systemRepository.saveAll(exoplanetarySystems);
    }

    public Collection<ExoplanetarySystem> parseNasaData(NasaResponseDto[] nasaExoplanetDtos) {
        Map<String, ExoplanetarySystem> exoplanetarySystemMap = new HashMap<>();

        // 1. Cargar sistemas existentes de la BD al mapa (1 sola consulta)
        List<ExoplanetarySystem> existingExoplanetarySystems = systemRepository.findAll();
        for (ExoplanetarySystem exoplanetarySystem : existingExoplanetarySystems) {
            exoplanetarySystemMap.put(exoplanetarySystem.getName(), exoplanetarySystem);
        }

        // 2. Procesar los DTOs en memoria
        for (NasaResponseDto dto : nasaExoplanetDtos) {
            // Obtener o crear el sistema en el mapa
            ExoplanetarySystem exoplanetarySystem = exoplanetarySystemMap.computeIfAbsent(
                    dto.getHostname(),
                    hostname -> nasaDataMapper.convertToExoplanetarySystem(dto)
            );

            // Verificar si el exoplaneta ya existe en este sistema para no duplicarlo
            boolean planetAlreadyExists = exoplanetarySystem.getExoplanets().stream()
                    .anyMatch(p -> p.getName().equals(dto.getPl_name()));

            if (!planetAlreadyExists) {
                java.lang.System.out.println("nuevo exoplaneta");
                Exoplanet exoplanet = nasaDataMapper.convertToExoplanet(dto);
                exoplanetarySystem.getExoplanets().add(exoplanet);
                exoplanet.setExoplanetarySystem(exoplanetarySystem);
            }
        }
        return exoplanetarySystemMap.values();
    }
}
