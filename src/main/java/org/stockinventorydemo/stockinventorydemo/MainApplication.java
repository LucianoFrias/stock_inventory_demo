package org.stockinventorydemo.stockinventorydemo;

import javafx.application.Application;

import javafx.stage.Stage;
import org.stockinventorydemo.stockinventorydemo.database.DatabaseInitializer;
import org.stockinventorydemo.stockinventorydemo.models.View;
import org.stockinventorydemo.stockinventorydemo.utils.SceneManager;

import java.io.IOException;

public class MainApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        DatabaseInitializer.initialize();


        SceneManager.setStage(stage);
        SceneManager.switchTo(View.LOGIN);
        stage.setTitle("Stock Inventory Demo");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}