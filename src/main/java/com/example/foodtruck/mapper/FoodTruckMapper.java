package com.example.foodtruck.mapper;

import com.example.foodtruck.model.FoodTruck;
import com.example.foodtruck.model.FoodTruckDto;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper(builder = @Builder(disableBuilder = true))
public interface FoodTruckMapper {
    FoodTruckMapper INSTANCE = Mappers.getMapper(FoodTruckMapper.class);

//    FoodTruckDto toDto(FoodTruck truck);

    List<FoodTruckDto> toDto(List<FoodTruck> trucks);
}