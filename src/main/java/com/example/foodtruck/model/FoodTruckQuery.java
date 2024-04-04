package com.example.foodtruck.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FoodTruckQuery {
    private Location location;
    private String foodName;

    private SortBy sortBy;
    @Min(0)
    Integer skip = 0;
    @Min(0) @Max(50)
    Integer limit = 10;

    public enum SortBy {
        DATE,
        DISTANCE
    }
}
