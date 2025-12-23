package org.stockinventorydemo.stockinventorydemo.models;

public enum View {

    LOGIN("hello-view.fxml", 600, 300, false),
    PRODUCTS("product-view.fxml", 1024, 768, true);

    public final String fxml;
    public final int width;
    public final int height;
    public final boolean resizable;

    View(String fxml, int width, int height, boolean resizable) {
        this.fxml = fxml;
        this.width = width;
        this.height = height;
        this.resizable = resizable;
    }
}
