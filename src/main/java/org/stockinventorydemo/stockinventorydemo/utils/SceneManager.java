package org.stockinventorydemo.stockinventorydemo.utils;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.stockinventorydemo.stockinventorydemo.models.View;

import java.io.IOException;

public class SceneManager {

    private static Stage stage;

    public static void setStage(Stage s) {
        stage = s;
    }

    public static void switchTo(View view) {
        try {
            Parent root = FXMLLoader.load(
                    SceneManager.class.getResource("/org/stockinventorydemo/stockinventorydemo/" + view.fxml)
            );

            stage.setScene(new Scene(root));
            stage.setWidth(view.width);
            stage.setHeight(view.height);
            stage.setResizable(view.resizable);
            stage.centerOnScreen();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
