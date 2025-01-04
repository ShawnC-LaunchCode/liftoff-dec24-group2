package com.waxofalltrades.liftoff_capstone_vinyl_destination.models;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.Cascade;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.Date;

@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    @Size(min = 3, max = 120)
    private String name;

    @Size(min = 3, max = 1250)
    private String description;

    @ManyToOne
    @NotNull(message = "Event Type Required")
    private EventType eventType;

    @NotNull
    private LocalDate eventDate;

    public Event() {
    }

    public Event(int id, String name, String description, EventType eventType, LocalDate eventDate) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.eventType = eventType;
        this.eventDate = eventDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public @NotNull @Size(min = 3, max = 120) String getName() {
        return name;
    }

    public void setName(@NotNull @Size(min = 3, max = 120) String name) {
        this.name = name;
    }

    public @Size(min = 3, max = 1250) String getDescription() {
        return description;
    }

    public void setDescription(@Size(min = 3, max = 1250) String description) {
        this.description = description;
    }

    public @Valid @NotNull EventType getEventType() {
        return eventType;
    }

    public void setEventType(@Valid @NotNull EventType eventType) {
        this.eventType = eventType;
    }

    public @NotNull LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(@NotNull LocalDate eventDate) {
        this.eventDate = eventDate;
    }

}
