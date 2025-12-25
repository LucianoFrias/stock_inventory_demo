package org.stockinventorydemo.stockinventorydemo;

import org.stockinventorydemo.stockinventorydemo.models.Product;
import org.stockinventorydemo.stockinventorydemo.repositories.ProductDAO;

import java.util.List;
import java.util.Optional;

public class ProductService {

    ProductDAO productDao;

    public ProductService(ProductDAO productDao){
        this.productDao = productDao;
    }

    public void insert(Product product){
        productDao.insert(product);
    }

    public void update(Product product){
        productDao.update(product);
    }

    public void delete(int id){
        productDao.delete(id);
    }

    public Optional<Product> findById(int id){
        return productDao.findById(id);
    }

    public List<Product> findAll(){
        return productDao.findAll();
    }

}
