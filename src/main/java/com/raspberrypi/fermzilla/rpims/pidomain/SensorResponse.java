package com.raspberrypi.fermzilla.rpims.pidomain;

import org.springframework.stereotype.Component;

@Component
public class SensorResponse {
    private Double thermoWellTemp;

    public SensorResponse() {
    }

    public Double getThermoWellTemp() {
        return thermoWellTemp;
    }

    public void setThermoWellTemp(Double thermoWellTemp) {
        this.thermoWellTemp = thermoWellTemp;
    }

    public SensorResponse(Double thermoWellTemp) {
        this.thermoWellTemp = thermoWellTemp;
    }
}