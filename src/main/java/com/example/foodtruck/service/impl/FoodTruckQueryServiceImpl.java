package com.example.foodtruck.service.impl;

import com.example.foodtruck.mapper.FoodTruckMapper;
import com.example.foodtruck.model.FoodTruckDto;
import com.example.foodtruck.model.FoodTruckQuery;
import com.example.foodtruck.model.Location;
import com.example.foodtruck.repository.FoodTruckRepository;
import com.example.foodtruck.service.FoodTruckQueryService;
import com.example.foodtruck.util.GeoUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

@RequiredArgsConstructor
@Service
public class FoodTruckQueryServiceImpl implements FoodTruckQueryService {
    private final FoodTruckRepository repository;

    @Override
    public List<FoodTruckDto> find(FoodTruckQuery query) {
        var trucks = repository.find(query);
        List<FoodTruckDto> result = FoodTruckMapper.INSTANCE.toDto(trucks);
        result.forEach(x -> x.setDistanceInMeter(getDistance(query.getLocation(), x.getLocation())));
        result.sort(getSortComparator(query.getSortBy()));
        return result;
    }

    private Long getDistance(Location fromLocation, Location toLocation) {
        if (fromLocation == null || toLocation == null) {
            return null;
        }

        return (long) GeoUtil.calculateDistance(fromLocation.getLatitude(), fromLocation.getLongitude(),
                toLocation.getLatitude(), toLocation.getLongitude());
    }

    private Comparator<FoodTruckDto> getSortComparator(String sort) {
        if (FoodTruckQuery.SortBy.DISTANCE.name().equalsIgnoreCase(sort)) {
            return Comparator.comparing(FoodTruckDto::getDistanceInMeter, Comparator.nullsLast(Long::compareTo));
        }
        return Comparator.comparing(FoodTruckDto::getReceived, Comparator.nullsFirst(LocalDate::compareTo)).reversed();
    }
}
