package com.jobhunter.controller.impl;

import com.jobhunter.controller.LocationController;
import com.jobhunter.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/location")
@RequiredArgsConstructor
public class LocationControllerImpl implements LocationController {

    private final LocationService locationService;

    @Override
    @GetMapping("/update")
    @Scheduled(cron = "0 0 4 1 * ?", zone = "Europe/Moscow") // INFO: Every 1 day of month in 04:00 (Europe/Moscow)
    public void updateLocation() {
        locationService.update();
    }
}
