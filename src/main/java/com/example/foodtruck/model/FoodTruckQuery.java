package com.example.foodtruck.model;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FoodTruckQuery {
    private Location location;
    @Size(max = 100)
    private String foodName;

    @Size(max = 100)
    private String sortBy;

    public enum SortBy {
        DATE,
        DISTANCE
    }
}
