package com.waxofalltrades.liftoff_capstone_vinyl_destination.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Size;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Size(max = 120, message = "Album name must be less than 120 characters")
    private String name;

    private Date releaseDate;

    @OneToMany(mappedBy = "itemId")
    private List<Item> items = new ArrayList<>();

}
