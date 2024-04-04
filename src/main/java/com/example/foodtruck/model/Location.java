package com.example.foodtruck.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Location {
    @Schema(example = "37.78788969990609")
    private Double latitude;
    @Schema(example = "-122.40053532677749")
    private Double longitude;
}
