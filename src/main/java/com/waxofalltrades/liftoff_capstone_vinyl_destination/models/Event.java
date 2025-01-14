package com.waxofalltrades.liftoff_capstone_vinyl_destination.models;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.Cascade;
import org.springframework.cglib.core.Local;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotBlank(message = "Name is required")
    @Size(min = 3, max = 120, message = "Name must be between 3 and 120 characters")
    private String name;

    @Size(min = 3, max = 1250, message = "Description must be between 3 and 1250 characters")
    private String description;

    @ManyToOne
    @NotNull
    private EventType eventType;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
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

    public @NotBlank(message = "Name is required") @Size(min = 3, max = 120) String getName() {
        return name;
    }

    public void setName(@NotBlank(message = "Name is required") @Size(min = 3, max = 120) String name) {
        this.name = name;
    }

    public @Size(min = 3, max = 1250) String getDescription() {
        return description;
    }

    public void setDescription(@Size(min = 3, max = 1250) String description) {
        this.description = description;
    }

    public @NotNull EventType getEventType() {
        return eventType;
    }

    public void setEventType(@NotNull EventType eventType) {
        this.eventType = eventType;
    }

    public @NotNull LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(@NotNull LocalDate eventDate) {
        this.eventDate = eventDate;
    }
}
