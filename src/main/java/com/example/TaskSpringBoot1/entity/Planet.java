package com.example.TaskSpringBoot1.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class Planet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty(message = "The field can not be empty ")
    @Size(min = 3, max = 30, message = "No short 3 and no longer than 30 characters  ")
    private String name;

    @ManyToOne()
    private Sovereign sovereign;

    public Planet(String name) {
        this.name = name;

    }

    public Planet() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
