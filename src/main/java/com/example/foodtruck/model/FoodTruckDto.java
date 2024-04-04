package com.example.foodtruck.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FoodTruckDto extends FoodTruck {
    private Long distanceInMeter;
}
