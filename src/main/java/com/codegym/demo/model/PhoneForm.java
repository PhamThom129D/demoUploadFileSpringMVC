package com.codegym.demo.model;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class PhoneForm {
    private int phoneID;
    private String phoneName;
    private int phonePrice;
    private int phoneQuantity;
    private MultipartFile[] phoneImage;

    public PhoneForm() {
    }

    public PhoneForm(int phoneID, MultipartFile[] phoneImage, String phoneName, int phonePrice, int phoneQuantity) {
        this.phoneID = phoneID;
        this.phoneImage = phoneImage;
        this.phoneName = phoneName;
        this.phonePrice = phonePrice;
        this.phoneQuantity = phoneQuantity;
    }

    public int getPhoneID() {
        return phoneID;
    }

    public void setPhoneID(int phoneID) {
        this.phoneID = phoneID;
    }

    public MultipartFile[] getPhoneImage() {
        return phoneImage;
    }

    public void setPhoneImage(MultipartFile[] phoneImage) {
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
