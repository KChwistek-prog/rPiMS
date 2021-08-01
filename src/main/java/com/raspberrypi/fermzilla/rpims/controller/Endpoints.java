package com.raspberrypi.fermzilla.rpims.controller;

import com.raspberrypi.fermzilla.rpims.pidomain.PiInfo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
@CrossOrigin(origins = "*")
public class Endpoints {
    private PiInfo piInfo;

    public Endpoints(PiInfo piInfo) {
        this.piInfo = piInfo;
    }

    @GetMapping("/temperature")
    public int showTemperature (PiInfo temp){
        return temp.getTemperature();
    }
}
