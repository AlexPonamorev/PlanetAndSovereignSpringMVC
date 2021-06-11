package com.example.TaskSpringBoot1.repository;

import com.example.TaskSpringBoot1.entity.Sovereign;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SovereignRepository extends CrudRepository<Sovereign, Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM  Sovereign ORDER BY age ASC ")
    public List<Sovereign> rankingByAge();

    @Query(nativeQuery = true, value = "SELECT * FROM Sovereign")
    public List<Sovereign> getListSovereign();

    @Query(nativeQuery = false, value = "SELECT s.name, p.name FROM Sovereign s LEFT  JOIN Planet p ON s.sovereign_id = p.sovereign where p.sovereign is  null ")
    public List<String> getPlaneJoinSovereignByPlanetNull();
}
