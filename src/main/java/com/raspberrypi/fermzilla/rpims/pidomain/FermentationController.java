package com.raspberrypi.fermzilla.rpims.pidomain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class FermentationController {
    private final PiInfo piInfo;
    private final CoolerController coolerController;
    private int requestedTemperature;

    @Autowired
    public FermentationController(PiInfo piInfo, CoolerController coolerController) {
        this.piInfo = piInfo;
        this.coolerController = coolerController;
    }

    public void temperatureController (int requestedTemperature, double currentTemp){
        if(currentTemp > requestedTemperature) {
            coolerController.startCooling();
        } else coolerController.stopCooling();
    }
}
