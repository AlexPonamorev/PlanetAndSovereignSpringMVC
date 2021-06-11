package com.example.TaskSpringBoot1.controllers;

import com.example.TaskSpringBoot1.entity.Planet;
import com.example.TaskSpringBoot1.exception.PlanetException;
import com.example.TaskSpringBoot1.exception.SovereignException;
import com.example.TaskSpringBoot1.services.PlanetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
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
    public String create(@ModelAttribute("addingPlanet") @Valid Planet planetNew, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()){
            model.addAttribute("newPlanet", new Planet());
            return "addingPlanet";}
        if (!planetService.savePlanet(planetNew)) {
            model.addAttribute("nameError", "Такая планета уже есть");
            model.addAttribute("newPlanet", new Planet());
            return "addingPlanet";
        }
        return "redirect:/start/show";
    }

    @PostMapping("/addSovereign")
    public String addSovereignPlanet(@RequestParam(value = "idP") long idP, @RequestParam(value = "sovereign_id") long idS) {
        try {
            planetService.addSovereign(idP, idS);
        }catch (PlanetException exception){
            throw new ResponseStatusException(HttpStatus.CONFLICT, exception.getMessage(), exception);
        }
        return "redirect:/start/show";
    }

    @GetMapping("/delete")
    public String deleteById(Model model) {
        List<Planet> planetList = planetService.getListPlanet();
        model.addAttribute("planetList", planetList);
        return "deletePlanet";
    }

    @PostMapping("/delete")
    public String deleteById(@RequestParam(value = "id") long id) {
        try {
            planetService.deleteById(id);
        }catch (SovereignException exception){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, exception.getMessage(), exception);
        }
        return "redirect:/start/show";
    }


}
