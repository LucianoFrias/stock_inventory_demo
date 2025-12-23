module org.stockinventorydemo.stockinventorydemo {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;

    opens org.stockinventorydemo.stockinventorydemo to javafx.fxml;
    exports org.stockinventorydemo.stockinventorydemo;
    exports org.stockinventorydemo.stockinventorydemo.controllers;
    opens org.stockinventorydemo.stockinventorydemo.controllers to javafx.fxml;
}