package org.stockinventorydemo.stockinventorydemo.repositories;


import org.stockinventorydemo.stockinventorydemo.models.Product;

import java.util.List;
import java.util.Optional;

public interface ProductDAO {
    void insert(Product product);
    void update(Product product);
    void delete(int id);
    Optional<Product> findById(int id);
    List<Product> findAll();
}
