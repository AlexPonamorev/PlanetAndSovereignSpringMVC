package com.example.TaskSpringBoot1.controllers;

import com.example.TaskSpringBoot1.entity.Planet;
import com.example.TaskSpringBoot1.entity.Sovereign;
import com.example.TaskSpringBoot1.repository.PlanetRepository;
import com.example.TaskSpringBoot1.repository.SovereignRepository;
import com.example.TaskSpringBoot1.services.SovereignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/sovereign")
public class SovereignController {
    private SovereignRepository sovereignRepository;
    private PlanetRepository planetRepository;
    private SovereignService sovereignService;

    @Autowired
    public SovereignController(SovereignRepository sovereignRepository, PlanetRepository planetRepository,SovereignService sovereignService) {
        this.sovereignRepository = sovereignRepository;
        this.planetRepository = planetRepository;
        this.sovereignService = sovereignService;
    }

    @GetMapping("/add")
    String add(Model model) {
        model.addAttribute("newSovereign", new Sovereign());
        return "addingSovereign";
    }

    @PostMapping()
    public String create(@ModelAttribute("addingSovereign") Sovereign sovereign) {
        sovereignRepository.save(sovereign);
        return "redirect:/start";
    }

    // отдаст форму для заполнения руководства со списком планет
    @GetMapping("/appoint/{id}")
    public String appoint(@PathVariable(value = "id") long id, Model model) {
        Optional<Sovereign> sovereignOptional = sovereignRepository.findById(id);
        Sovereign sovereign = sovereignOptional.get();
        model.addAttribute("appointed", sovereign);
        // запросить список планет которыми руководит повелитель с переданным ID на данный момент
        List<Planet> planetList = planetRepository.getListBySovereign(id);
        model.addAttribute("planetList", planetList);
        // запросить свободные планеты и отправить в модель
        List<Planet> planetListIsNotSovereign = planetRepository.getPlanetBySovereignIsNull();
        model.addAttribute("planetNull", planetListIsNotSovereign);

        return "appointmentOfLeaderShip";
    }

    @GetMapping("/rankingUp")
    public String rankingByAge(Model model){
    List<String> top10NameList = sovereignService.rankingByAge();
    model.addAttribute("nameList" , top10NameList);
        return "top10List";
    }

    @PostMapping("/delete")
    public String delete(long id){
        sovereignService.delete(id);
        return "redirect:/start";
    }
}
