package com.raghugannaram.reelvault.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raghugannaram.reelvault.model.HealthCheckModel;

@RestController
@RequestMapping("/")
public class HealthCheckController {

    @GetMapping("/health-check")
    public ResponseEntity<HealthCheckModel> healthCheck() {
        HealthCheckModel healthCheckResponse = new HealthCheckModel("OK", "ReelVault is up and running...🚀");
        return ResponseEntity.ok(healthCheckResponse);
    }
}
