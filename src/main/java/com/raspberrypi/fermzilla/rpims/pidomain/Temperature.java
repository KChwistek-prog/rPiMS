package com.raspberrypi.fermzilla.rpims.pidomain;

import com.pi4j.component.temperature.TemperatureSensor;
import com.pi4j.io.w1.W1Master;
import com.pi4j.temperature.TemperatureScale;
import org.springframework.stereotype.Component;

@Component
public class Temperature {

    public double tempSensor() {
        double temperature = 0;
        W1Master w1Master = new W1Master();
        for (TemperatureSensor device : w1Master.getDevices(TemperatureSensor.class)) {
            temperature = device.getTemperature(TemperatureScale.CELSIUS);
        }
        return temperature;
    }
}
