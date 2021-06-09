package com.example.TaskSpringBoot1.repository;

import com.example.TaskSpringBoot1.entity.Sovereign;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SovereignRepository extends CrudRepository<Sovereign, Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM Sovereign ")
    public List<Sovereign> getSovereignList();

    @Query (nativeQuery = true, value = "SELECT * FROM  Sovereign ORDER BY age ASC ")
    public List<Sovereign> rankingByAge();
}
