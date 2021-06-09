package com.example.TaskSpringBoot1.services;

import com.example.TaskSpringBoot1.entity.Planet;
import com.example.TaskSpringBoot1.entity.Sovereign;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class FactoryObjects {

    public Set<Planet> genSetPlanets(int quantity) {
        Set<Planet> planetSet = new HashSet<>();
        List<String> planetNames = Arrays.asList("Ahch-To", "Anoat", "Bespin", "Cantonica", "Christophsis",
                "Coruscant", "Dagobah", "Eadu", "Endor", "Exegol", "Felucia", "Genesis");

        for (int i = 0; i < quantity; ++i) {
            planetSet.add(new Planet(planetNames.get((int) (Math.random() * planetNames.size()))));
        }
        return planetSet;
    }

    public Set<Sovereign> genSetSovereign(int quantity) {
        Set<Sovereign> sovereignSet = new HashSet<>();
        List<String> sovereignNames = Arrays.asList("Leia Organa", "Han Solo", "Luke Skywalker", "Jobal Naberrie", "Pooja Naberrie",
                "Ruwee Naberrie", "Ryoo Naberrie", "Beru Whitesun Lars ", "Cliegg Lars", "Aika Lars", "Queen Breha Organa", "Darth Vader");

        for (int i = 0; i < quantity; ++i) {

            sovereignSet.add(new Sovereign(sovereignNames.get((int) (Math.random() * sovereignNames.size())),
                    (int) (Math.random() * 999) + 100));
        }
        return sovereignSet;
    }
}
