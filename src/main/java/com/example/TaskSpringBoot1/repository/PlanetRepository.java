package com.example.TaskSpringBoot1.repository;

import com.example.TaskSpringBoot1.entity.Planet;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PlanetRepository extends CrudRepository<Planet, Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM Planet")
    public List<Planet> getListPlanet();

    @Query(value = "SELECT c FROM Planet c WHERE c.name = :name")
    public Planet getPlanetByName(@Param("name") String name);

    @Query(nativeQuery = true, value = "SELECT s FROM Planet s WHERE s.sovereign_id = id")
    public List<Planet> getListBySovereign(@Param("id") long id);

    @Query(value = "SELECT c FROM Planet c WHERE c.sovereign is null")
    public List<Planet> getPlanetBySovereignIsNull();
}
