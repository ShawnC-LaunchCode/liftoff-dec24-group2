package com.waxofalltrades.liftoff_capstone_vinyl_destination.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Condition {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    @ManyToMany(mappedBy = "conditions")
    private final List<Item> items = new ArrayList<>();

    public Condition(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Condition() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
