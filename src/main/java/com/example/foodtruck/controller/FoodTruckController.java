package com.example.foodtruck.controller;

import com.example.foodtruck.model.FoodTruckDto;
import com.example.foodtruck.model.FoodTruckQuery;
import com.example.foodtruck.service.FoodTruckQueryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/food-trucks")
@Validated
public class FoodTruckController {
    private final FoodTruckQueryService queryService;

    @GetMapping
    public List<FoodTruckDto> find(@Valid FoodTruckQuery query) {
        return queryService.find(query);
    }
}
