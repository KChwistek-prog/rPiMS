package com.raspberrypi.fermzilla.rpims.controller;

import com.raspberrypi.fermzilla.rpims.pidomain.PiController;
import com.raspberrypi.fermzilla.rpims.pidomain.PiInfo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
@CrossOrigin(origins = "*")
public class Endpoints {
    private final PiInfo piInfo;
    private final PiController piController;

    public Endpoints(PiInfo piInfo, PiController piController) {
        this.piInfo = piInfo;
        this.piController = piController;
    }

    @GetMapping("/temperature")
    public double showTemperature () {
        return piInfo.getTemp();
    }

    @GetMapping("/startCooling")
    public void startCooling(){
        piController.startCool();
    }

    @GetMapping("/stopCooling")
    public void stopCooling(){
        piController.stopCool();
    }


}

