package com.raspberrypi.fermzilla.rpims.pidomain;

import com.pi4j.component.temperature.TemperatureSensor;
import com.pi4j.io.w1.W1Master;
import com.pi4j.temperature.TemperatureScale;
import org.springframework.stereotype.Component;

@Component
public class SensorReader {

    public SensorResponse getTemp() {
        SensorResponse sensorResponse = new SensorResponse();
        W1Master w1Master = new W1Master();
        for (TemperatureSensor rPi : w1Master.getDevices(TemperatureSensor.class)) {
            sensorResponse.setInnerTemperature(rPi.getTemperature(TemperatureScale.CELSIUS));
        }
        return sensorResponse;
    }

}
