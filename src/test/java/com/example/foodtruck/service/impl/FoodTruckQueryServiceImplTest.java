package com.example.foodtruck.service.impl;

import com.example.foodtruck.model.FoodTruck;
import com.example.foodtruck.model.FoodTruckQuery;
import com.example.foodtruck.model.Location;
import com.example.foodtruck.repository.FoodTruckRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class FoodTruckQueryServiceImplTest {
    FoodTruckQueryServiceImpl service;
    FoodTruckRepository repository = mock(FoodTruckRepository.class);

    @BeforeEach
    void setUp() {
        service = new FoodTruckQueryServiceImpl(repository);
    }

    @Test
    void find_HaveData_OrderByDistance() {
        // CASE
        FoodTruckQuery query = new FoodTruckQuery();
        query.setLocation(new Location(37.72980548057414, -122.39924710472444));
        query.setSortBy(FoodTruckQuery.SortBy.DISTANCE);
        when(repository.find(query)).thenReturn(getTestTrucks());

        // WHEN
        var result = service.find(query);

        // THEN
        assertTrue(result.get(0).getDistanceInMeter() <= result.get(1).getDistanceInMeter());
    }

    @Test
    void find_HaveData_OrderByDate() {
        // CASE
        FoodTruckQuery query = new FoodTruckQuery();
        query.setLocation(new Location(37.72980548057414, -122.39924710472444));
        query.setSortBy(FoodTruckQuery.SortBy.DATE);
        when(repository.find(query)).thenReturn(getTestTrucks());

        // WHEN
        var result = service.find(query);

        // THEN
        assertFalse(result.get(0).getReceived().isBefore(result.get(1).getReceived()));
    }

    private static List<FoodTruck> getTestTrucks() {
        return List.of(
                FoodTruck.builder()
                        .locationId("1")
                        .location(new Location(37.78788969990609, -122.40053532677749))
                        .received(LocalDate.of(2024, 4, 2))
                        .build(),
                FoodTruck.builder()
                        .locationId("2")
                        .location(new Location(37.72980548057414, -122.39924710472444))
                        .received(LocalDate.of(2024, 4, 1))
                        .build()
        );
    }
}