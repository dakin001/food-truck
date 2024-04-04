package com.example.foodtruck.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FoodTruckQuery {
    private Location location;
    @Schema(example = "taco")
    @Size(max = 100)
    private String foodName;

    @Schema(defaultValue = "Distance", description = "Date or Distance")
    @Size(max = 100)
    private String sortBy;

    public enum SortBy {
        DATE,
        DISTANCE
    }
}
