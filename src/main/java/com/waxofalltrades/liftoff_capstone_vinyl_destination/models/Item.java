package com.waxofalltrades.liftoff_capstone_vinyl_destination.models;

public class Item {

    private int id;
    private double price;
    private int qtyInStock;
    private String album;
    private String conditionType;
    private String formatType;
    public Item(int id, double price, int qtyInStock, String album, String conditionType, String formatType) {
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

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getConditionType() {
        return conditionType;
    }

    public void setConditionType(String conditionType) {
        this.conditionType = conditionType;
    }

    public String getFormatType() {
        return formatType;
    }

    public void setFormatType(String formatType) {
        this.formatType = formatType;
    }
}
