package org.stockinventorydemo.stockinventorydemo.controllers;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.stockinventorydemo.stockinventorydemo.ProductService;
import org.stockinventorydemo.stockinventorydemo.models.Product;
import org.stockinventorydemo.stockinventorydemo.models.View;
import org.stockinventorydemo.stockinventorydemo.repositories.ProductDAOImpl;
import org.stockinventorydemo.stockinventorydemo.utils.SceneManager;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.List;

public class ProductController {

    private ProductService productService = new ProductService(new ProductDAOImpl());


    @FXML private TableView<Product> productTable;

    public void initialize(){
        autoCompleteColumns();
        fetchProductData();
    }

    public void fetchProductData(){
        List<Product> products = productService.findAll();
        System.out.println("Productos obtenidos: " + products.size());

        ObservableList<Product> observableProducts =
                FXCollections.observableArrayList(products);

        productTable.setItems(observableProducts);
    }

    public void autoCompleteColumns(){
        productTable.getColumns().clear();

        for (Field field : Product.class.getDeclaredFields()) {

            // Evitar static o transient
            if (Modifier.isStatic(field.getModifiers())) continue;

            field.setAccessible(true);

            TableColumn<Product, Object> col =
                    new TableColumn<>(field.getName().toUpperCase());

            col.setCellValueFactory(param -> {
                try {
                    Object value = field.get(param.getValue());
                    return new ReadOnlyObjectWrapper<>(value);
                } catch (IllegalAccessException e) {
                    return null;
                }
            });

            productTable.getColumns().add(col);
        }
    }

    @FXML
    private void logout() {
        SceneManager.switchTo(View.LOGIN);
    }


}
