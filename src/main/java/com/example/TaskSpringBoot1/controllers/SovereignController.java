package com.example.TaskSpringBoot1.controllers;

import com.example.TaskSpringBoot1.entity.Planet;
import com.example.TaskSpringBoot1.entity.Sovereign;
import com.example.TaskSpringBoot1.services.PlanetService;
import com.example.TaskSpringBoot1.services.SovereignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/sovereign")
public class SovereignController {

    private SovereignService sovereignService;
    private PlanetService planetService;

    @Autowired
    public SovereignController(SovereignService sovereignService, PlanetService planetService) {
        this.sovereignService = sovereignService;
        this.planetService = planetService;
    }

    @GetMapping("/add")
    String add(Model model) {
        model.addAttribute("newSovereign", new Sovereign());
        return "addingSovereign";
    }

    @PostMapping("/add")
    public String create(@ModelAttribute("addingSovereign")  @Valid Sovereign sovereign, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()){
            model.addAttribute("newSovereign", new Sovereign());
            return "addingSovereign";
        }
        sovereignService.saveSovereign(sovereign);
        return "redirect:/start/show";
    }

    // Gives a form for the appointment of sovereign with a list of free planets
    @GetMapping("/appoint/{id}")
    public String appoint(@PathVariable(value = "id") long id, Model model) {
        Sovereign sovereign = sovereignService.getSovereignById(id);
        model.addAttribute("appointed", sovereign);
        // Request a list of planets which managed sovereign with the transferred ID at the moment
        List<Planet> planetList = planetService.getListSovereignById(id);
        model.addAttribute("planetList", planetList);
        // Request free planets and send to the model
        List<Planet> planetListIsNotSovereign = planetService.getPlanetBySovereignIsNull();
        model.addAttribute("planetNull", planetListIsNotSovereign);
        return "appointmentOfLeaderShip";
    }

    @GetMapping("/rankingUp")
    public String rankingByAge(Model model) {
        List<String> top10NameList = sovereignService.rankingByAge();
        model.addAttribute("nameList", top10NameList);
        return "top10List";
    }

    @GetMapping("/delete")
    public String delete(Model model) {
        List<Sovereign> sovereignList = sovereignService.getListSovereign();
        model.addAttribute("sovereignList", sovereignList);
        return "deleteSovereign";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam(value = "id") long id) {
        sovereignService.delete(id);
        return "redirect:/start/show";
    }
}
