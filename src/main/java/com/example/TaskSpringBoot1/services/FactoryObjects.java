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
        Collections.shuffle(planetNames, new Random(3));
        Set<String> nameSet = new HashSet<>(planetNames);
        Iterator<String> setIterator = nameSet.iterator();
        for (int i = 0; i < quantity; ++i) {
            planetSet.add(new Planet(setIterator.next()));
        }
        return planetSet;
    }

    public Set<Sovereign> genSetSovereign(int quantity) {
        Set<Sovereign> sovereignSet = new HashSet<>();
        List<String> sovereignNames = Arrays.asList("Leia Organa", "Han Solo", "Luke Skywalker", "Jobal Naberrie", "Pooja Naberrie",
                "Ruwee Naberrie", "Ryoo Naberrie", "Beru Whitesun Lars ", "Cliegg Lars", "Aika Lars", "Queen Breha Organa", "Darth Vader");
        Collections.shuffle(sovereignNames,new Random(3));
        Set<String> nameSet = new HashSet<>(sovereignNames);

        Iterator<String> setIterator = nameSet.iterator();
        for (int i = 0; i < quantity; ++i) {
            sovereignSet.add(new Sovereign(setIterator.next(),
                    (int) (Math.random() * 999) + 100));
        }
        return sovereignSet;
    }
}
