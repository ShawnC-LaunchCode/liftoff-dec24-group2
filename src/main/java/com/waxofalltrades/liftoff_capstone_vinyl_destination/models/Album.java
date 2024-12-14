package com.waxofalltrades.liftoff_capstone_vinyl_destination.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;


public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Size(max = 120, message = "Album name must be less than 120 characters")
    private String name;

}
