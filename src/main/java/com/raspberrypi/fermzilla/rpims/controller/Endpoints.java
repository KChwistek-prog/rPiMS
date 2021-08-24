package com.raspberrypi.fermzilla.rpims.controller;

import com.raspberrypi.fermzilla.rpims.pidomain.FermentationController;
import com.raspberrypi.fermzilla.rpims.pidomain.PiController;
import com.raspberrypi.fermzilla.rpims.pidomain.PiInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
@CrossOrigin(origins = "*")
public class Endpoints {
    private final PiInfo piInfo;
    private final PiController piController;
    private final FermentationController fermentationController;

    @Autowired
    public Endpoints(PiInfo piInfo, PiController piController, FermentationController fermentationController) {
        this.piInfo = piInfo;
        this.piController = piController;
        this.fermentationController = fermentationController;
    }

    @GetMapping("/temperature")
    public double showTemperature () {
        return piInfo.getTemp();
    }

    @PutMapping("/setTemp/{temp}")
    public void setTemperature(@PathVariable(value = "temp") int setTemp){
        fermentationController.temperatureController(setTemp, piInfo.getTemp());
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

