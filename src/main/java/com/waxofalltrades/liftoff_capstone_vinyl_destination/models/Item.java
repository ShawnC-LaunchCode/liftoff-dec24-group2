package com.waxofalltrades.liftoff_capstone_vinyl_destination.models;

import jakarta.persistence.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Item {
    @EmbeddedId
    private ItemId itemId;

    private double price;

    private int qtyInStock = 1;

    public Item() {
    }

    public Item(ItemId itemId, double price, int qtyInStock) {
        this.itemId = itemId;
        this.price = price;
        this.qtyInStock = qtyInStock;
    }

    public ItemId getItemId() {
        return itemId;
    }

    public void setItemId(ItemId itemId) {
        this.itemId = itemId;
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
