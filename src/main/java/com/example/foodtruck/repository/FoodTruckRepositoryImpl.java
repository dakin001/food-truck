package com.example.foodtruck.repository;

import com.example.foodtruck.model.FoodTruck;
import com.example.foodtruck.model.FoodTruckQuery;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Repository
public class FoodTruckRepositoryImpl implements FoodTruckRepository {
    private List<FoodTruck> data = new ArrayList<>();

    @Override
    public void save(List<FoodTruck> list) {
        data = list;
    }

    @Override
    public List<FoodTruck> find(FoodTruckQuery query) {
        return data.stream().filter(item -> isFoodNameMatch(item, query)).toList();
    }

    private boolean isFoodNameMatch(FoodTruck item, FoodTruckQuery query) {
        if (!StringUtils.hasText(query.getFoodName())) {
            return true;
        }
        if (!StringUtils.hasText(item.getFoodItems())) {
            return false;
        }
        return item.getFoodItems().toLowerCase().contains(query.getFoodName().toLowerCase());
    }
}
