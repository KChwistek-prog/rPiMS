package com.raspberrypi.fermzilla.rpims.controller;

import com.raspberrypi.fermzilla.rpims.pidomain.CoolerController;
import com.raspberrypi.fermzilla.rpims.pidomain.FermentationController;
import com.raspberrypi.fermzilla.rpims.pidomain.SensorReader;
import com.raspberrypi.fermzilla.rpims.pidomain.SensorResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

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
    public SensorResponseDto showTemperature () throws IOException {
        return new SensorResponseDto(sensorReader.getTemp().thermowellTemp(), sensorReader.getTemp().roomTemperature(), sensorReader.getTemp().setupPressure());
    }

    @PutMapping("/setTemp/{temp}")
    public void setTemperature(@PathVariable(value = "temp") int setTemp) throws IOException {
        fermentationController.temperatureController(setTemp, sensorReader.getTemp().thermowellTemp());
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

