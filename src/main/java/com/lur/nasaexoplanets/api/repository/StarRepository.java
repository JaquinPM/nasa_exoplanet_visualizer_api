package com.lur.nasaexoplanets.api.repository;

import com.lur.nasaexoplanets.api.model.Star;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StarRepository extends JpaRepository<Star, Integer> {
}
