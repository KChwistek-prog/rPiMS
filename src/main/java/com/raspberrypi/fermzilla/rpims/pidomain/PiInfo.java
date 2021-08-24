package com.raspberrypi.fermzilla.rpims.pidomain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


@Controller
public class PiInfo {
    private final Temperature piTempSensor;

    @Autowired
    public PiInfo(Temperature piTempSensor) {
        this.piTempSensor = piTempSensor;
    }

    public double getTemp() {
        double temp = piTempSensor.fermzillaInnerTempSensor();
        return temp;
    }

}
