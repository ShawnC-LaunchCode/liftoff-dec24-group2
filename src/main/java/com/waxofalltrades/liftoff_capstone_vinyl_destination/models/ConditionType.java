package com.waxofalltrades.liftoff_capstone_vinyl_destination.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class ConditionType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @OneToMany(mappedBy = "conditionType")
    private final List<Item> items = new ArrayList<>();

    public ConditionType(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public ConditionType() {
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
