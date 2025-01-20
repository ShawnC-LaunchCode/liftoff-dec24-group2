package com.waxofalltrades.liftoff_capstone_vinyl_destination.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "item", uniqueConstraints = { @UniqueConstraint(columnNames = {"album_id", "condition_type_id", "format_type_id"})})
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    @Min(value = 0, message = "Value must be greater than 0")
    private double price;

    @NotNull
    @Min(0)
    private int qtyInStock = 1;

    @ManyToOne
    @JoinColumn(name = "album_id")
    @NotNull
    private Album album;

    @ManyToOne
    @JoinColumn(name = "condition_type_id")
    @NotNull
    private ConditionType conditionType;

    @ManyToOne
    @JoinColumn(name = "format_type_id")
    @NotNull
    private FormatType formatType;

    public Item() {
    }

    public Item(int id, double price, int qtyInStock, Album album, ConditionType conditionType, FormatType formatType) {
        this.id = id;
        this.price = price;
        this.qtyInStock = qtyInStock;
        this.album = album;
        this.conditionType = conditionType;
        this.formatType = formatType;

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

    public ConditionType getConditionType() {
        return conditionType;
    }

    public void setConditionType(ConditionType conditionType) {
        this.conditionType = conditionType;
    }

    public FormatType getFormatType() {
        return formatType;
    }

    public void setFormatType(FormatType formatType) {
        this.formatType = formatType;
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
