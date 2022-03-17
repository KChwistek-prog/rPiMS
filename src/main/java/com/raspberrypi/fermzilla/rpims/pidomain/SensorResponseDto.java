package com.raspberrypi.fermzilla.rpims.pidomain;

import org.springframework.stereotype.Component;

@Component
public record SensorResponseDto(Double thermowellTemp, Double roomTemperature, Double setupPressure) {
}