package com.example.foodtruck.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class MobileFoodFacilityPermit {
    @JsonProperty("locationid")
    private String locationId;
    @JsonProperty("Applicant")
    private String applicant;
    @JsonProperty("FacilityType")
    private String facilityType;
    @JsonProperty("LocationDescription")
    private String locationDescription;
    @JsonProperty("Address")
    private String address;
    @JsonProperty("blocklot")
    private String blockLot;
    private String block;
    private String lot;
    private String permit;
    private String status;
    @JsonProperty("FoodItems")
    private String foodItems;
    @JsonProperty("Latitude")
    private Double latitude;
    @JsonProperty("Longitude")
    private Double longitude;
    @JsonProperty("Schedule")
    private String schedule;
    @JsonProperty("dayshours")
    private String daysHours;
    @JsonProperty("Received")
    private String received;
    @JsonProperty("Location")
    private String location;
}
