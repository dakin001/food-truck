package com.example.foodtruck.repository;

import com.example.foodtruck.model.FoodTruck;

import java.util.List;

public interface FoodTruckRepository {
    void save(List<FoodTruck> list);

    void findAll();
}
