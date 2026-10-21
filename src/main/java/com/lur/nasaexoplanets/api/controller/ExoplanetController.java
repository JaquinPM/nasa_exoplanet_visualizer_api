package com.lur.nasaexoplanets.api.controller;

import com.lur.nasaexoplanets.api.dto.ExoplanetResponseDTO;
import com.lur.nasaexoplanets.api.model.Exoplanet;
import com.lur.nasaexoplanets.api.service.ExoplanetService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class ExoplanetController {
    private ExoplanetService exoplanetService;

    @GetMapping("/exoplanet")
    public Page<ExoplanetResponseDTO> getAll(
            @RequestParam(required = false) Integer page,
            @RequestParam(required = false) Integer limit
    ) {
        return exoplanetService.getAll(page, limit);
    }

    @GetMapping("/exoplanet/{id}")
    public ResponseEntity<ExoplanetResponseDTO> getById(@PathVariable("id") int id){

        return ResponseEntity.ok(exoplanetService.getById(id));
    }

    @GetMapping("/exoplanet/search")
    public Page<ExoplanetResponseDTO> searchByName(
            @RequestParam(required = true) String name,
            @RequestParam(required = false) Integer page,
            @RequestParam(required = false) Integer limit){
            return exoplanetService.getByNameContaining(name, page, limit);
    }

    @GetMapping("/exoplanet/system/{id}")
    public ResponseEntity<List<ExoplanetResponseDTO>> getBySystemId(@PathVariable int systemId){
        return ResponseEntity.ok(exoplanetService.getBySystemId(systemId));
    }
}
