package com.waxofalltrades.liftoff_capstone_vinyl_destination.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class StorageType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    @ManyToMany(mappedBy = "storageTypes")
    private final List<Item> items = new ArrayList<>();

    public StorageType(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public StorageType() {
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

    public List<Item> getItems() {
        return items;
    }


}
