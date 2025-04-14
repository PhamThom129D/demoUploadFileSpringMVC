package com.codegym.demo.model;

import java.util.List;

public class Phone {
    private int phoneID;
    private String phoneName;
    private int phonePrice;
    private int phoneQuantity;
    private List<String> phoneImage;

    public Phone() {
    }

    public Phone(int phoneID, String phoneName, int phonePrice, int phoneQuantity, List<String> phoneImage) {
        this.phoneID = phoneID;
        this.phoneName = phoneName;
        this.phonePrice = phonePrice;
        this.phoneQuantity = phoneQuantity;
        this.phoneImage = phoneImage;
    }

    public int getPhoneID() {
        return phoneID;
    }

    public void setPhoneID(int phoneID) {
        this.phoneID = phoneID;
    }

    public List<String> getPhoneImage() {
        return phoneImage;
    }

    public void setPhoneImage(List<String> phoneImage) {
        this.phoneImage = phoneImage;
    }

    public String getPhoneName() {
        return phoneName;
    }

    public void setPhoneName(String phoneName) {
        this.phoneName = phoneName;
    }

    public int getPhonePrice() {
        return phonePrice;
    }

    public void setPhonePrice(int phonePrice) {
        this.phonePrice = phonePrice;
    }

    public int getPhoneQuantity() {
        return phoneQuantity;
    }

    public void setPhoneQuantity(int phoneQuantity) {
        this.phoneQuantity = phoneQuantity;
    }
}
