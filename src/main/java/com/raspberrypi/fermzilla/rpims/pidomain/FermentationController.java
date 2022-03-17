package com.raspberrypi.fermzilla.rpims.pidomain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FermentationController {
    private final SensorReader sensorReader;
    private final CoolerController coolerController;
    private int requestedTemperature;

    @Autowired
    public FermentationController(SensorReader sensorReader, CoolerController coolerController) {
        this.sensorReader = sensorReader;
        this.coolerController = coolerController;
    }

    public void temperatureController (int requestedTemperature, double currentTemp){
        if(currentTemp > requestedTemperature) {
            coolerController.startCooling();
        } else coolerController.stopCooling();
    }
}
