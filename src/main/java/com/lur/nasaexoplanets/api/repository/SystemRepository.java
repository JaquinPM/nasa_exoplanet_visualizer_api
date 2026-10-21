package com.lur.nasaexoplanets.api.repository;


import com.lur.nasaexoplanets.api.model.ExoplanetarySystem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemRepository extends JpaRepository<ExoplanetarySystem, Integer> {
}
