package org.stockinventorydemo.stockinventorydemo;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.stockinventorydemo.stockinventorydemo.models.Product;
import org.stockinventorydemo.stockinventorydemo.models.View;
import org.stockinventorydemo.stockinventorydemo.utils.SceneManager;
import org.stockinventorydemo.stockinventorydemo.utils.ScreenResolutionHandler;

import java.io.IOException;

public class MainApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        SceneManager.setStage(stage);
        SceneManager.switchTo(View.LOGIN);
        stage.setTitle("Stock Inventory Demo");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}