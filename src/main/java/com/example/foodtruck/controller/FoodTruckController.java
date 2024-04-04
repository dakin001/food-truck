package com.example.foodtruck.controller;

import com.example.foodtruck.model.FoodTruckDto;
import com.example.foodtruck.model.FoodTruckQuery;
import com.example.foodtruck.service.FoodTruckQueryService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
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

    @Operation(summary = "query food trucks", description = "query food trucks by food name and longitude and latitude", tags = {"Food Truck"})
    @GetMapping
    public List<FoodTruckDto> find(@Valid @ParameterObject FoodTruckQuery query) {
        return queryService.find(query);
    }
}
