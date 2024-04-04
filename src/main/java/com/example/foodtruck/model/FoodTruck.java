package com.example.foodtruck.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FoodTruck {
    private String locationId;
    private String address;
    private String blockLot;
    private String foodItems;
    private String daysHours;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate received;
    private Location location;
}
