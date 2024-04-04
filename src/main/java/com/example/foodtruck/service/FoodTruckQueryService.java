package com.example.foodtruck.service;

import com.example.foodtruck.model.FoodTruckDto;
import com.example.foodtruck.model.FoodTruckQuery;

import java.util.List;

public interface FoodTruckQueryService {
    List<FoodTruckDto> find(FoodTruckQuery query);
}
