package com.example.TaskSpringBoot1.services;

import com.example.TaskSpringBoot1.entity.Planet;
import com.example.TaskSpringBoot1.entity.Sovereign;
import com.example.TaskSpringBoot1.repository.PlanetRepository;
import com.example.TaskSpringBoot1.repository.SovereignRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlanetService {
    private PlanetRepository planetRepository;
    private SovereignRepository sovereignRepository;

    @Autowired
    public PlanetService(PlanetRepository planetRepository, SovereignRepository sovereignRepository) {
        this.planetRepository = planetRepository;
        this.sovereignRepository = sovereignRepository;
    }

    public boolean savePlanet(Planet planet) {
        Planet loaded = planetRepository.getPlanetByName(planet.getName());
        if (loaded != null) {
            return false;
        }
        planetRepository.save(planet);
        return true;
    }

    public void addSovereign(long idPlanet, long idS) {
        Planet planet = planetRepository.findById(idPlanet).orElse(null);
        Optional<Sovereign> sovereignOptional = sovereignRepository.findById(idS);
        Sovereign sovereign = sovereignOptional.get();

        if (planet.getSovereign() == null) {
            planet.setSovereign(sovereign);
            planetRepository.save(planet);
        }
    }

    public List<Planet> getListPlanet() {
        return planetRepository.getListPlanet();
    }

    public void delete(long id) {
        planetRepository.deleteById(id);
    }

    public List<Planet> getListSovereignById(long id) {
        return planetRepository.getListBySovereign(id);
    }

    public List<Planet> getPlanetBySovereignIsNull() {
        return planetRepository.getPlanetBySovereignIsNull();
    }
}
