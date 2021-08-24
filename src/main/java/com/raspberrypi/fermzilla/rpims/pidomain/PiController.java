package com.raspberrypi.fermzilla.rpims.pidomain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class PiController {
    private final CoolerController coolerController;

    @Autowired
    public PiController(CoolerController coolerController) {
        this.coolerController = coolerController;
    }

    public void startCool() {
        coolerController.startCooling();
    }

    public void stopCool(){
        coolerController.stopCooling();
    }
}
