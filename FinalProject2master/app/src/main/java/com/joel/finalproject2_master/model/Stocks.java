package com.joel.finalproject2_master.model;

public class Stocks {
    private String id, itemName, qty;

    public Stocks(){

    }

    public Stocks(String id,String itemName, String qty){
        this.id = id;
        this.itemName = itemName;
        this.qty = qty;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return itemName;
    }

    public void setName(String itemName) {
        this.itemName = itemName;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

}
