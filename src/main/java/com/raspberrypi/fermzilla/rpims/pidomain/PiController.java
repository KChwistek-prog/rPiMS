package com.raspberrypi.fermzilla.rpims.pidomain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class PiController {
    private final Cooling cooling;

    @Autowired
    public PiController(Cooling cooling) {
        this.cooling = cooling;
    }


    public void startCool() {
        cooling.startCooling();
    }

    public void stopCool(){
        cooling.stopCooling();
    }
}
