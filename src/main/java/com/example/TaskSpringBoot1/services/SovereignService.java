package com.example.TaskSpringBoot1.services;

import com.example.TaskSpringBoot1.entity.Planet;
import com.example.TaskSpringBoot1.entity.Sovereign;
import com.example.TaskSpringBoot1.exception.SovereignException;
import com.example.TaskSpringBoot1.repository.PlanetRepository;
import com.example.TaskSpringBoot1.repository.SovereignRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SovereignService {
    SovereignRepository sovereignRepository;
    PlanetRepository planetRepository;

    @Autowired
    public SovereignService(SovereignRepository sovereignRepository, PlanetRepository planetRepository) {
        this.sovereignRepository = sovereignRepository;
        this.planetRepository = planetRepository;
    }

    public List<String> rankingByAge() {
        List<Sovereign> sovereignList = sovereignRepository.rankingByAge();
        List<String> nameList = sovereignList.stream().map(sovereign -> sovereign.getName()).limit(10).collect(Collectors.toList());
        return nameList;
    }

    public void deleteById(long id) {
        if (!sovereignRepository.existsById(id)) throw new SovereignException(" Recording does not exist ");
        sovereignRepository.deleteById(id);
        List<Planet> planetList = planetRepository.getListBySovereign(id);
        List<Planet> planetList1 = planetList.stream().peek(s -> s.setSovereign(null)).collect(Collectors.toList());
        planetRepository.saveAll(planetList1);
    }

    public List<Sovereign> getListSovereign() {
        return sovereignRepository.getListSovereign();
    }

    public Sovereign getSovereignById(long id) {
        Optional<Sovereign> sovereignOptional = sovereignRepository.findById(id);
        Sovereign sovereign = sovereignOptional.get();
        return sovereign;
    }

    public void saveSovereign(Sovereign sovereign) {
        sovereignRepository.save(sovereign);
    }
}
