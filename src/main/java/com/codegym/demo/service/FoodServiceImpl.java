package com.codegym.demo.service;

import com.codegym.demo.model.Food;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FoodServiceImpl implements IFoodService {
    private static final Map<Integer, Food> foods ;
    static {
        foods = new HashMap<>();
        foods.put(1,new Food(1,"Táo",null));
        foods.put(2,new Food(2,"Táo1",null));
        foods.put(3,new Food(3,"Táo2",null));
        foods.put(4,new Food(4,"Táo3",null));
        foods.put(5,new Food(5,"Táo4",null));
        foods.put(6,new Food(6,"Táo5",null));

    }
    @Override
    public List<Food> getFoods() {
        return new ArrayList<>(foods.values());
    }

    @Override
    public void addFood(Food food) {
        foods.put(food.getId(),food);
    }
}
