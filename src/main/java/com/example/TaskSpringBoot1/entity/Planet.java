package com.example.TaskSpringBoot1.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
public class Planet {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    @ManyToOne
    private Sovereign sovereign;

    public Planet(String name) {
        this.name = name;

    }

    public Planet() {
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
        return " " + name + " " ;
    }
}
