package com.example.TaskSpringBoot1.entity;

import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Entity
public class Planet {
    @Id
    @GenericGenerator(name = "generator", strategy = "increment")
    @GeneratedValue(generator = "generator")
    private Long planet_id;

    @NotEmpty(message = "The field can not be empty ")
    @Size(min = 3, max = 30, message = "No short 3 and no longer than 30 characters  ")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    private Sovereign sovereign;

    public Planet(String name) {
        this.name = name;

    }

    public Planet() {
    }

    public Long getPlanet_id() {
        return planet_id;
    }

    public void setPlanet_id(Long planet_id) {
        this.planet_id = planet_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sovereign getSovereign() {
        return sovereign;
    }

    public void setSovereign(Sovereign sovereign) {
        this.sovereign = sovereign;
    }
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return " " + name + " ";
    }
}
