package com.waxofalltrades.liftoff_capstone_vinyl_destination.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.antlr.v4.runtime.misc.NotNull;

public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    private int ItemId;

    private double price;

    private int QtyInStock;

    public Item(int id, int itemId, double price, int qtyInStock) {
        this.id = id;
        ItemId = itemId;
        this.price = price;
        QtyInStock = qtyInStock;
    }

    public Item() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getItemId() {
        return ItemId;
    }

    public void setItemId(int itemId) {
        ItemId = itemId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQtyInStock() {
        return QtyInStock;
    }

    public void setQtyInStock(int qtyInStock) {
        QtyInStock = qtyInStock;
    }


}
