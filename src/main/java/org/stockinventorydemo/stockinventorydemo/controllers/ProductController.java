package org.stockinventorydemo.stockinventorydemo.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import org.stockinventorydemo.stockinventorydemo.models.View;
import org.stockinventorydemo.stockinventorydemo.utils.SceneManager;

public class ProductController {

    @FXML private TableView<?> productTable;

    @FXML
    private void logout() {
        SceneManager.switchTo(View.LOGIN);
    }
}
