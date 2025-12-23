package org.stockinventorydemo.stockinventorydemo.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.stockinventorydemo.stockinventorydemo.models.View;
import org.stockinventorydemo.stockinventorydemo.utils.SceneManager;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController {

    @FXML private TextField userField;
    @FXML private PasswordField passField;
    @FXML private Label errorLabel;

    @FXML
    private void handleLogin() {

        String user = userField.getText();
        String pass = passField.getText();

        if (user.equals("admin") && pass.equals("1234")) {
            SceneManager.switchTo(View.PRODUCTS);
        } else {
            errorLabel.setText("Usuario o contraseña incorrectos");
        }
    }
}
