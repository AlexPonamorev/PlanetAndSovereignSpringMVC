package com.example.TaskSpringBoot1.controllers;

import com.example.TaskSpringBoot1.services.PlanetService;
import com.example.TaskSpringBoot1.services.SovereignService;
import com.example.TaskSpringBoot1.services.StartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/start")
public class StartController {

    private StartService startService;
    private SovereignService sovereignService;
    private PlanetService planetService;

    @Autowired
    public StartController(StartService startService, SovereignService sovereignService, PlanetService planetService) {
        this.startService = startService;
        this.sovereignService = sovereignService;
        this.planetService = planetService;
    }

    @GetMapping()
    public String starting() {
        return "downloadPage";
    }

    @GetMapping("/load")
    public String loader(Model model) {
        startService.loader();
        return "redirect:/start/show";
    }

    @GetMapping("/show")
    public String showStartApp(Model model) {
        model.addAttribute("sovereignList", sovereignService.getListSovereign());
        model.addAttribute("planetList", planetService.getListPlanet());
        return "showStartApp";
    }
}
