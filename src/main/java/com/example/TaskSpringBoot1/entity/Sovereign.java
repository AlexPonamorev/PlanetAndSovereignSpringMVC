package com.example.TaskSpringBoot1.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Sovereign {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private int age;
    @OneToMany(mappedBy = "sovereign")
    private Set<Planet> planetSet = new HashSet<>();

    public Set<Planet> getPlanetSet() {
        return planetSet;
    }

    public void setPlanetSet(Set<Planet> planetSet) {
        this.planetSet = planetSet;
    }

    public Sovereign(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Sovereign() {
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}

