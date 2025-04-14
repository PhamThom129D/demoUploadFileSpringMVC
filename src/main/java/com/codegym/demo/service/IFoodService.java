package com.codegym.demo.service;

import com.codegym.demo.model.Food;

import java.util.List;

public interface IFoodService {
    List<Food> getFoods();
    void addFood(Food food);
}
