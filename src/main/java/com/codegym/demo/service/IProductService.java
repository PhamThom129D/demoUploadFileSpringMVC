package com.codegym.demo.service;

import com.codegym.demo.model.Product;

import java.util.List;


public interface IProductService {

    List<Product> getAllProducts();
    Product getProductById(int id);
    void addProduct(Product product);
    void updateProduct(Product product);
    void deleteProduct(int id);
    List<Product> getProductsByName(String name);
}
