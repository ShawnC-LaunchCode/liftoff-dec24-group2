package com.waxofalltrades.liftoff_capstone_vinyl_destination.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

@Entity
public class EventType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    @Size(min = 3, max = 45)
    private String name;

    @OneToOne(mappedBy = "eventType")
    private Event event;

    public EventType() {
    }

    public EventType(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public @NotNull @Size(min = 3, max = 45) String getName() {
        return name;
    }

    public void setName(@NotNull @Size(min = 3, max = 45) String name) {
        this.name = name;
    }
}
