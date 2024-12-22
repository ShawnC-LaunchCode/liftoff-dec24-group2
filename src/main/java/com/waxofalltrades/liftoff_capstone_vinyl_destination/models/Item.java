package com.waxofalltrades.liftoff_capstone_vinyl_destination.models;

import jakarta.persistence.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Item {
    @EmbeddedId
    private ItemId Id;

    private double price;

    private int qtyInStock;

    public Item() {
    }

    public Item(ItemId id, double price, int qtyInStock) {
        Id = id;
        this.price = price;
        this.qtyInStock = qtyInStock;
    }

    public ItemId getId() {
        return Id;
    }

    public void setId(ItemId id) {
        Id = id;
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
