package com.example.foodtruck.service.impl;

import com.example.foodtruck.model.FoodTruck;
import com.example.foodtruck.repository.FoodTruckRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;

class FoodTruckSyncServiceImplTest {

    FoodTruckSyncServiceImpl service;
    FoodTruckRepository repository = mock(FoodTruckRepository.class);

    @BeforeEach
    void setUp() {
        service = new FoodTruckSyncServiceImpl(repository);
    }

    @Test
    void init_fromResourceFile_parseAndSave() {
        // CASE
        //noinspection unchecked
        ArgumentCaptor<List<FoodTruck>> argCaptor = ArgumentCaptor.forClass(List.class);
        doNothing().when(repository).save(argCaptor.capture());

        // WHEN
        service.init();

        // THEN
        List<FoodTruck> foodTrucks = argCaptor.getValue();
        FoodTruck foodTruck = foodTrucks.get(0);
        assertNotNull(foodTruck.getLocationId());
    }
}