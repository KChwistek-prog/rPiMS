package com.raspberrypi.fermzilla.rpims.pidomain;

import com.pi4j.io.gpio.*;
import org.springframework.stereotype.Component;

@Component
public class Cooling {
    final GpioController gpio = GpioFactory.getInstance();
    //▼ pi4j uses wiringpi! eg. physical pin 40 represented by gpio 21 number on board and 29 on wpi ▼
    final GpioPinDigitalOutput pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_29, "CoolingLed", PinState.LOW);

    public void startCooling() {
            pin.high();
    }

    public void stopCooling(){
            pin.low();
    }

}
