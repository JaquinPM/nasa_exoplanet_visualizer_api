package com.lur.nasaexoplanets.api.repository;

import com.lur.nasaexoplanets.api.model.Exoplanet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ExoplanetRepository extends JpaRepository<Exoplanet, Integer> {

     List<Exoplanet> findByNameContaining(String name);

     Page<Exoplanet> findByNameContaining(String name, Pageable pageable);

     List<Exoplanet> getByExoplanetarySystemId(int id);
}
