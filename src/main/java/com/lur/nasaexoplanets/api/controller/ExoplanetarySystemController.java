package com.lur.nasaexoplanets.api.controller;

import com.lur.nasaexoplanets.api.dto.ExoSystemFullResponseDto;
import com.lur.nasaexoplanets.api.dto.ExoSystemResponseDto;
import com.lur.nasaexoplanets.api.service.SystemService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api")
public class ExoplanetarySystemController {
    private SystemService systemService;

    @GetMapping("/system")
    public List<ExoSystemResponseDto> getAll(){
        return systemService.getAll();
    }

    @GetMapping("/system/{id}")
    public ResponseEntity<ExoSystemFullResponseDto> getById(@PathVariable int id){

        return  ResponseEntity.ok(systemService.getById(id));
    }

}
