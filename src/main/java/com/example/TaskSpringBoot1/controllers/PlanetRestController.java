package com.example.TaskSpringBoot1.controllers;

import com.example.TaskSpringBoot1.repository.SovereignRepository;
import com.example.TaskSpringBoot1.services.PlanetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/test")
@RestController
public class PlanetRestController {


    private final PlanetService planetService;
    private  SovereignRepository sovereignRepository;

    @Autowired
    public PlanetRestController(PlanetService planetService, SovereignRepository sovereignRepository) {
        this.planetService = planetService;
//        this.planetRepository = planetRepository;
        this.sovereignRepository = sovereignRepository;
    }

    @GetMapping("/q")
    public List<String> getPlaneJoinSovereign(){
        List<String> pl =  planetService.getPlaneJoinPlanet();
        for ( String plS : pl){
            System.out.println(plS);
        }
        return pl;
    }
    @GetMapping("/w")
    public List<String> getPlaneJoinSovereignByPlanetNull(){
        List<String> pl =  sovereignRepository.getPlaneJoinSovereignByPlanetNull();
        for ( String plS : pl){
            System.out.println(plS);
        }
        return pl;
    }
}

