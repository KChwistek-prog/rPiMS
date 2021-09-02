package com.raspberrypi.fermzilla.rpims.controller;

import com.raspberrypi.fermzilla.rpims.pidomain.CoolerController;
import com.raspberrypi.fermzilla.rpims.pidomain.FermentationController;
import com.raspberrypi.fermzilla.rpims.pidomain.SensorReader;
import com.raspberrypi.fermzilla.rpims.pidomain.SensorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
@CrossOrigin(origins = "*")
public class Endpoints {
    private final SensorReader sensorReader;
    private final CoolerController coolerController;
    private final FermentationController fermentationController;

    @Autowired
    public Endpoints(SensorReader sensorReader, CoolerController coolerController, FermentationController fermentationController) {
        this.sensorReader = sensorReader;
        this.coolerController = coolerController;
        this.fermentationController = fermentationController;
    }

    @GetMapping(value = "/temperature")
    @ResponseBody
    public SensorResponse showTemperature () {
        return new SensorResponse(sensorReader.getTemp().getInnerTemperature());
    }

    @PutMapping("/setTemp/{temp}")
    public void setTemperature(@PathVariable(value = "temp") int setTemp){
        fermentationController.temperatureController(setTemp, sensorReader.getTemp().getInnerTemperature());
    }

    @GetMapping("/startCooling")
    public void coolingOn(){
        coolerController.startCooling();
    }

    @GetMapping("/stopCooling")
    public void coolingOff(){
        coolerController.stopCooling();
    }


}

