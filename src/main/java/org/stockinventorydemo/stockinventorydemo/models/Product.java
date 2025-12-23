package org.stockinventorydemo.stockinventorydemo.models;

public class Product {
    int id;
    int inventoryNumber;
    int model;

    public Product(){}

    public Product(int id, int inventoryNumber, int model) {
        this.id = id;
        this.inventoryNumber = inventoryNumber;
        this.model = model;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getInventoryNumber() {
        return inventoryNumber;
    }

    public void setInventoryNumber(int inventoryNumber) {
        this.inventoryNumber = inventoryNumber;
    }

    public int getModel() {
        return model;
    }

    public void setModel(int model) {
        this.model = model;
    }
}
