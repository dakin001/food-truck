package com.example.foodtruck.service.impl;

import com.example.foodtruck.model.FoodTruck;
import com.example.foodtruck.model.Location;
import com.example.foodtruck.model.MobileFoodFacilityPermit;
import com.example.foodtruck.repository.FoodTruckRepository;
import com.example.foodtruck.service.FoodTruckSyncService;
import com.example.foodtruck.util.CsvUtils;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodTruckSyncServiceImpl implements FoodTruckSyncService {
    private final FoodTruckRepository repository;
    @Value("${remoteDataUrl:https://data.sfgov.org/api/views/rqzj-sfat/rows.csv}")
    private String remoteDataUrl;

    private static final String DEFAULT_DATA_FILE = "/data/Mobile_Food_Facility_Permit.csv";
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyyMMdd");

    @Override
    public void init() {
        List<MobileFoodFacilityPermit> permitList = getDefaultData();
        List<FoodTruck> foodTruckList = convertToEntity(permitList);
        repository.save(foodTruckList);
    }

    @Override
    public void sync() {
        List<MobileFoodFacilityPermit> permitList = getRemoteData();
        List<FoodTruck> foodTruckList = convertToEntity(permitList);
        repository.save(foodTruckList);
    }

    @SneakyThrows
    private List<MobileFoodFacilityPermit> getDefaultData() {
        try (InputStream inputStream = this.getClass().getResourceAsStream(DEFAULT_DATA_FILE)) {
            return CsvUtils.parse(inputStream, MobileFoodFacilityPermit.class);
        }
    }

    @SneakyThrows
    private List<MobileFoodFacilityPermit> getRemoteData() {
        URL url = URI.create(remoteDataUrl).toURL();
        try (InputStream inputStream = url.openStream()) {
            return CsvUtils.parse(inputStream, MobileFoodFacilityPermit.class);
        }
    }

    private List<FoodTruck> convertToEntity(List<MobileFoodFacilityPermit> permitList) {
        return permitList.stream().map(this::convertToEntity).toList();
    }

    private FoodTruck convertToEntity(MobileFoodFacilityPermit permit) {
        boolean hasLocation = permit.getLatitude() != null && permit.getLatitude() > 0
                && permit.getLongitude() != null && permit.getLongitude() > 0;
        return FoodTruck.builder()
                .locationId(permit.getLocationId())
                .address(permit.getAddress())
                .blockLot(permit.getBlockLot())
                .foodItems(permit.getFoodItems())
                .daysHours(permit.getDaysHours())
                .received(LocalDate.parse(permit.getReceived(), DATE_FORMATTER))
                .location(hasLocation ? new Location(permit.getLatitude(), permit.getLongitude()) : null)
                .build();
    }
}
