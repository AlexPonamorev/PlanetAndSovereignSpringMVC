package com.example.TaskSpringBoot1.repository;

import com.example.TaskSpringBoot1.entity.Planet;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface PlanetRepository extends CrudRepository<Planet, Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM Planet")
    public List<Planet> getListPlanet();

    @Query(value = "SELECT c FROM Planet c WHERE c.name = :name")
    public Planet getPlanetByName(@Param("name") String name);

    @Query(value = "SELECT p FROM Planet p WHERE p.sovereign.sovereign_id = :id")
    public List<Planet> getListBySovereign(@Param("id") long id);

    @Query(value = "SELECT p FROM Planet p WHERE p.sovereign is null")
    public List<Planet> getPlanetBySovereignIsNull();

    @Query(value = "SELECT p FROM Planet p WHERE p.sovereign is not null")
    public List<Planet> getPlanetBySovereignIsNotNull();

    /***************************************************************/
    // не работает
//    @Query(nativeQuery = true, value = "SELECT * FROM   Planet  JOIN   Sovereign ON Sovereign.sovereign_id = Planet.sovereign ")
//    public List<String> getPlaneJoinPlanet();
    @Query(nativeQuery = false, value = "SELECT p.name,s.name FROM Planet  p  JOIN Sovereign  s ON s.sovereign_id = p.sovereign ")
    public List<String> getPlaneJoinPlanet();

}