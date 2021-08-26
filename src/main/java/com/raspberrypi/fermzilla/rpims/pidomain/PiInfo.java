package com.raspberrypi.fermzilla.rpims.pidomain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;


@Component
public class PiInfo {
    private final Temperature piTempSensor;

    @Autowired
    public PiInfo(Temperature piTempSensor) {
        this.piTempSensor = piTempSensor;
    }

    public double getTemp() {
        return piTempSensor.fermzillaInnerTempSensor();
    }

}
