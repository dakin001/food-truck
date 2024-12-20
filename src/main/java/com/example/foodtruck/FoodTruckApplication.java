package com.example.foodtruck;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class FoodTruckApplication {

    public static void main(String[] args) {
        SpringApplication.run(FoodTruckApplication.class, args);
    }

}
