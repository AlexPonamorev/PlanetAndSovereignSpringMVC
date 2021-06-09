package com.example.TaskSpringBoot1.controllers;

import com.example.TaskSpringBoot1.entity.Planet;
import com.example.TaskSpringBoot1.services.PlanetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/planet")
public class PlanetController {
    private PlanetService planetService;

    @Autowired
    public PlanetController(PlanetService planetService) {
        this.planetService = planetService;

    }

    @GetMapping("/add")
    public String addingPlanet(Model model) {
        model.addAttribute("newPlanet", new Planet());
        return "addingPlanet";
    }

    @PostMapping("/add")
    public String create(@ModelAttribute("addingPlanet") Planet planetNew, Model model) {
        if (!planetService.savePlanet(planetNew)) {
            model.addAttribute("nameError", "Такая планета уже есть");
            model.addAttribute("newPlanet", new Planet());
            return "addingPlanet";
        }
        return "redirect:/start/show";
    }

    @PostMapping("/addSovereign")
    public String addSovereign(@RequestParam(value = "idP") long idP, @RequestParam(value = "id") long idS) {
        planetService.addSovereign(idP, idS);
        return "redirect:/start/show";
    }

    @GetMapping("/delete")
    public String delete(Model model) {
        List<Planet> planetList = planetService.getListPlanet();
        model.addAttribute("planetList", planetList);
        return "deletePlanet";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam(value = "id") long id) {
        planetService.delete(id);
        return "redirect:/start/show";
    }
}
