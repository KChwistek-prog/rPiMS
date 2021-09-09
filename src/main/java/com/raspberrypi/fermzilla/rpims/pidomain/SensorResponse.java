package com.raspberrypi.fermzilla.rpims.pidomain;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class SensorResponse {
    private Double innerTemperature;

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
