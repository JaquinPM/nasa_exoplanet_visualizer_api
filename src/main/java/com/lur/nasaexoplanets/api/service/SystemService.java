package com.lur.nasaexoplanets.api.service;

import com.lur.nasaexoplanets.api.component.ExoplanetarySystemMapper;
import com.lur.nasaexoplanets.api.dto.ExoSystemFullResponseDto;
import com.lur.nasaexoplanets.api.dto.ExoSystemResponseDto;
import com.lur.nasaexoplanets.api.exception.ExoSystemNotFoundException;
import com.lur.nasaexoplanets.api.repository.SystemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class SystemService {
    private SystemRepository systemRepository;
    private ExoplanetarySystemMapper exoplanetarySystemMapper;

    public List<ExoSystemResponseDto> getAll() {
        return systemRepository.findAll().stream().map(
                system -> exoplanetarySystemMapper.toDto(system)
        ).toList();
    }

    public ExoSystemFullResponseDto getById(int id) {
        return systemRepository.findById(id).map(
                system -> exoplanetarySystemMapper.toFullDto(system)
        ).orElseThrow(
                () -> new ExoSystemNotFoundException("Syste, with id=%d not found".formatted(id))
        );
    }
}
