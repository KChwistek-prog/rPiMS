package com.raspberrypi.fermzilla.rpims.pidomain;

import org.springframework.stereotype.Component;

@Component
public class SensorResponse {
    private Double innerTemperature;

    public SensorResponse() {
    }

    public Double getInnerTemperature() {
        return innerTemperature;
    }

    public void setInnerTemperature(Double innerTemperature) {
        this.innerTemperature = innerTemperature;
    }

    public SensorResponse(Double innerTemperature) {
        this.innerTemperature = innerTemperature;
    }
}
