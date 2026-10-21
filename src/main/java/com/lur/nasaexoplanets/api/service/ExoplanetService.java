package com.lur.nasaexoplanets.api.service;

import com.lur.nasaexoplanets.api.component.ExoplanetMapper;
import com.lur.nasaexoplanets.api.dto.ExoplanetResponseDTO;
import com.lur.nasaexoplanets.api.exception.ExoplanetNotFoundException;
import com.lur.nasaexoplanets.api.model.Exoplanet;
import com.lur.nasaexoplanets.api.repository.ExoplanetRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ExoplanetService {
    private ExoplanetRepository exoplanetRepository;
    private ExoplanetMapper exoplanetMapper;

    public Page<ExoplanetResponseDTO> getAll(Integer page, Integer limit){
        int pageNum = (page != null) ? page - 1 : 0;
        int pageSize = (limit != null) ? limit : 20; // o el tamaño por defecto que prefieras

        Pageable pageable = PageRequest.of(pageNum, pageSize);
        return exoplanetRepository.findAll(pageable)
                .map(exoplanetMapper::toDto);

    }


    public ExoplanetResponseDTO getById(int id) {
        return exoplanetRepository.findById(id) // Retorna un Optional<Exoplanet>
                .map( exoplanet ->
                        exoplanetMapper.toDto(exoplanet)
                ).orElseThrow(
                        () -> new ExoplanetNotFoundException("Exoplanet with id=%d not found".formatted(id))
                );
    }

    public Page<ExoplanetResponseDTO> getByNameContaining(String name, Integer page, Integer limit) {
        int pageNum = (page != null) ? page - 1 : 0;
        int pageSize = (limit != null) ? limit : 20;

        Pageable pageable = PageRequest.of(pageNum, pageSize);

        return exoplanetRepository.findByNameContaining(name, pageable)
                .map(exoplanetMapper::toDto);
    }

    public List<ExoplanetResponseDTO> getBySystemId(int id){
        return exoplanetRepository.getByExoplanetarySystemId(id).stream().map(
                exoplanet -> exoplanetMapper.toDto(exoplanet)
        ).toList();
    }
}
