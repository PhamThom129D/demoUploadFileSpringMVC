package com.codegym.demo.model;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class FoodForm {
    private int id;
    private String name;
    private List<MultipartFile> path_image;

    public FoodForm(int id, String name, List<MultipartFile> path_image) {
        this.id = id;
        this.name = name;
        this.path_image = path_image;
    }

    public FoodForm() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MultipartFile> getPath_image() {
        return path_image;
    }

    public void setPath_image(List<MultipartFile> path_image) {
        this.path_image = path_image;
    }

}
