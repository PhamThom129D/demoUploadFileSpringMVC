package com.codegym.demo.model;

import org.springframework.web.multipart.MultipartFile;

public class ProductForm {
    private int productID;
    private String productName;
    private int productPrice;
    private int productQuantity;
    private MultipartFile[] productImage;
    public ProductForm() {}

    public ProductForm(int productID, String productName, int productPrice, int productQuantity) {
        this.productID = productID;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
    }

    public ProductForm(int productID, String productName, int productPrice, int productQuantity, MultipartFile[] productImage) {
        this.productID = productID;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
        this.productImage = productImage;
    }

    public MultipartFile[] getProductImage() {
        return productImage;
    }

    public void setProductImage(MultipartFile[] productImage) {
        this.productImage = productImage;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    @Override
    public String toString() {
        return "ProductForm{" +
                "productID=" + productID +
                ", productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", productQuantity=" + productQuantity +
                ", productImage=" + productImage +
                '}';
    }
}
