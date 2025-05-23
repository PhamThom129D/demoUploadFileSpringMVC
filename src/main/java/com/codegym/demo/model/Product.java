package com.codegym.demo.model;

import java.util.Arrays;

public class Product {
    private int productID;
    private String productName;
    private int productPrice;
    private int productQuantity;
    private String[] productImage;

    public Product() {
    }

    // ✅ Constructor đúng: truyền vào mảng String[]
    public Product(int productID, String productName, int productPrice, int productQuantity, String[] productImage) {
        this.productID = productID;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
        this.productImage = productImage;
    }

    // ✅ Có thể thêm constructor nhận List<String> nếu cần tiện hơn:
    public Product(int productID, String productName, int productPrice, int productQuantity, java.util.List<String> uploadedFileNames) {
        this.productID = productID;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
        this.productImage = uploadedFileNames.toArray(new String[0]);
    }

    // Getter / Setter
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

    public String[] getProductImage() {
        return productImage;
    }

    public void setProductImage(String[] productImage) {
        this.productImage = productImage;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productID=" + productID +
                ", productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", productQuantity=" + productQuantity +
                ", productImage=" + Arrays.toString(productImage) +
                '}';
    }
}
