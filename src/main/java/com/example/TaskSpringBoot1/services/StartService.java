package com.example.TaskSpringBoot1.services;

import com.example.TaskSpringBoot1.entity.Planet;
import com.example.TaskSpringBoot1.entity.Sovereign;
import com.example.TaskSpringBoot1.repository.PlanetRepository;
import com.example.TaskSpringBoot1.repository.SovereignRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class StartService {
    PlanetRepository planetRepository;
    SovereignRepository sovereignRepository;
    FactoryObjects factoryObjects;

    @Autowired
    public StartService(PlanetRepository planetRepository, FactoryObjects factoryObjects, SovereignRepository sovereignRepository) {
        this.planetRepository = planetRepository;
        this.factoryObjects = factoryObjects;
        this.sovereignRepository = sovereignRepository;
    }

    public void loader() {
        Set<Planet> planetSet = factoryObjects.genSetPlanets(10);
        Set<Sovereign> sovereignSet = factoryObjects.genSetSovereign(10);
        planetRepository.saveAll(planetSet);
        sovereignRepository.saveAll(sovereignSet);
    }
}
