package com.example.TaskSpringBoot1.controllers;

import com.example.TaskSpringBoot1.entity.Planet;
import com.example.TaskSpringBoot1.entity.Sovereign;
import com.example.TaskSpringBoot1.services.FactoryObjects;
import com.example.TaskSpringBoot1.repository.PlanetRepository;
import com.example.TaskSpringBoot1.repository.SovereignRepository;
import com.example.TaskSpringBoot1.services.StartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;

@Controller
@RequestMapping("/start")
public class StartController {

    private PlanetRepository planetRepository;
    private SovereignRepository sovereignRepository;
    private StartService startService;

    @Autowired
    public StartController(PlanetRepository planetRepository, SovereignRepository sovereignRepository, StartService startService) {
        this.planetRepository = planetRepository;
        this.sovereignRepository = sovereignRepository;
        this.startService = startService;
    }

    @GetMapping("/load")
    public String loader(Model model) {
        startService.loader();
        return "redirect:/start";
    }

    @GetMapping()
    public String showStartApp(Model model) {
        model.addAttribute("sovereignList", sovereignRepository.getSovereignList());
        model.addAttribute("planetList", planetRepository.getListPlanet());
        return "showStartApp";
    }

}
