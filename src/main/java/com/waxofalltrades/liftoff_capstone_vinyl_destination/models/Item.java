package com.waxofalltrades.liftoff_capstone_vinyl_destination.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    private Album album;

    private double price;

    private int qtyInStock;

    @ManyToMany
    private final List<ConditionType> conditionTypes = new ArrayList<>();

    @ManyToMany
    private final List<FormatType> formatTypes = new ArrayList<>();

    public Item(int id, Album album, double price, int qtyInStock) {
        this.id = id;
        this.album = album;
        this.price = price;
        this.qtyInStock = qtyInStock;
    }

    public Item() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQtyInStock() {
        return qtyInStock;
    }

    public void setQtyInStock(int qtyInStock) {
        this.qtyInStock = qtyInStock;
    }


}
