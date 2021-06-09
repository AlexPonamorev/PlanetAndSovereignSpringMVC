package com.example.TaskSpringBoot1.controllers;

import com.example.TaskSpringBoot1.entity.Planet;
import com.example.TaskSpringBoot1.entity.Sovereign;
import com.example.TaskSpringBoot1.services.PlanetService;
import com.example.TaskSpringBoot1.services.SovereignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping()
    public String create(@ModelAttribute("addingSovereign") Sovereign sovereign) {
        sovereignService.saveSovereign(sovereign);
        return "redirect:/start/show";
    }

    // отдаст форму для заполнения руководства со списком планет
    @GetMapping("/appoint/{id}")
    public String appoint(@PathVariable(value = "id") long id, Model model) {
        Sovereign sovereign = sovereignService.getSovereignById(id);
        model.addAttribute("appointed", sovereign);
        // запросить список планет которыми руководит повелитель с переданным ID на данный момент
        List<Planet> planetList = planetService.getListSovereignById(id);
        model.addAttribute("planetList", planetList);
        // запросить свободные планеты и отправить в модель
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
        System.out.println(" id = " + id);
        return "redirect:/start/show";
    }
}
