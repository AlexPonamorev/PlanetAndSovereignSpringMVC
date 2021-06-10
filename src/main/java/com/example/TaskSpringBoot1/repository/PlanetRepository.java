package com.example.TaskSpringBoot1.repository;

import com.example.TaskSpringBoot1.entity.Planet;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlanetRepository extends CrudRepository<Planet, Long> {
    @Query(value = "select c from Planet c")
    public List<Planet> getListPlanet();

    @Query(value = "SELECT c FROM Planet c WHERE c.name = :name")
    public Planet getPlanetByName(@Param("name") String name);

    @Query(value = "SELECT p FROM Planet p WHERE p.sovereign.id = :id")
    public List<Planet> getListBySovereign(@Param("id") long id);

    @Query(value = "SELECT p FROM Planet p WHERE p.sovereign is null")
    public List<Planet> getPlanetBySovereignIsNull();

    @Query(value = "SELECT p FROM Planet p WHERE p.sovereign is not null")
    public List<Planet> getPlanetBySovereignIsNotNull();

    /***************************************************************/
    @Query( value = "select p from Planet p join Sovereign s on s.id = s.id")
    public List<String> getPlaneJoinSovereign();
}
