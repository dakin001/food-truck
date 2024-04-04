package com.example.foodtruck.repository;

import com.example.foodtruck.model.FoodTruck;
import com.example.foodtruck.model.FoodTruckQuery;

import java.util.List;

public interface FoodTruckRepository {
    void save(List<FoodTruck> list);

    List<FoodTruck> find(FoodTruckQuery query);
}
