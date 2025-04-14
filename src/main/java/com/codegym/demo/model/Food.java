package com.codegym.demo.model;

import java.util.List;

public class Food {
    private int id;
    private String name;
    private List<String> path_image;

    public Food(int id, String name, List<String> path_image) {
        this.id = id;
        this.name = name;
        this.path_image = path_image;
    }

    public Food() {
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

    public List<String> getPath_image() {
        return path_image;
    }

    public void setPath_image(List<String> path_image) {
        this.path_image = path_image;
    }

    @Override
    public String toString() {
        return "Food{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", path_image=" + path_image +
                '}';
    }
}
