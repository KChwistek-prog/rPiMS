package com.raspberrypi.fermzilla.rpims.pidomain;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Component
public class SensorReader {

    public SensorResponseDto getTemp() throws IOException {
        return new SensorResponseDto(thermowellTemperature(), roomTemperature(), checkPressure());
    }

    private Double thermowellTemperature() throws IOException {
        String file = "/sys/bus/w1/devices/28-000000038e50/temperature";
        BufferedReader reader = new BufferedReader(new FileReader(file));
        var line = reader.readLine();
        reader.close();
        var temp = Double.parseDouble(line);
        return temp / 1000;
    }

    private Double roomTemperature(){
        //dummy method, waiting for sensor on rPi
        return 23.2;
    }

    private Double checkPressure(){
        //placeholder method, waiting for pressure transducer
        return 1.0;
    }

}

