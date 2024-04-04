package com.example.foodtruck.config;

import com.example.foodtruck.service.FoodTruckSyncService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
@RequiredArgsConstructor
public class SyncRunner implements ApplicationRunner {
    private final FoodTruckSyncService syncService;

    @Override
    public void run(ApplicationArguments args) {
        syncService.init();
    }

    @Scheduled(fixedRate = 24, timeUnit = TimeUnit.HOURS)
    public void sync() {
        syncService.sync();
    }
}