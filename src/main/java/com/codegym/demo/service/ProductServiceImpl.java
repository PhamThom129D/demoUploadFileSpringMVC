package com.codegym.demo.service;

import com.codegym.demo.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements IProductService{
    private static final Map<Integer,Product> products ;
    static {
        products = new HashMap<>();
        products.put(1,new Product(1,"Iphone14",2000,15));
        products.put(2,new Product(2,"Iphone15",2000,15));
        products.put(3,new Product(3,"Iphone13",2000,15));
        products.put(4,new Product(4,"Iphone12",2000,15));
        products.put(5,new Product(5,"Iphone11",2000,15));
        products.put(6,new Product(6,"Iphone10",2000,15));
        products.put(7,new Product(7,"Iphone9",2000,15));
        products.put(8,new Product(8,"Iphone8",2000,15));
    }
    @Override
    public List<Product> getAllProducts() {
        return new ArrayList<>(products.values());
    }

    @Override
    public Product getProductById(int id) {
        Product product = products.get(id);
        return product;
    }

    @Override
    public void addProduct(Product product) {
        products.put(product.getProductID(),product);
    }

    @Override
    public void updateProduct(Product product) {
        if(products.containsKey(product.getProductID())){
            products.put(product.getProductID(),product);
        }
    }

    @Override
    public void deleteProduct(int id) {
        products.remove(id);
    }

    @Override
    public List<Product> getProductsByName(String name) {
        List<Product> productList = new ArrayList<>();
        for(Product product : products.values()){
            if(product.getProductName().toLowerCase().contains(name.toLowerCase())){
                productList.add(product);
            }

        }
        return productList;
    }
}
